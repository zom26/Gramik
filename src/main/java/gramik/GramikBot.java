package gramik;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.fasterxml.jackson.databind.node.ObjectNode;
import gramik.parameters.ParseMode;
import gramik.parameters.ReplyMarkup;
import gramik.types.*;

public class GramikBot {
    private final String url;
    private final FilterContainer filters = new FilterContainer();
    private final FilterContainer oneTimeFilters = new FilterContainer();
    private final ExecutorService executor;
    private long lastUpdate = 0;
    private boolean showUnfilteredUpdates;

    public final static ObjectMapper objectMapper = new ObjectMapper();

    public GramikBot(String botToken) {
        this(botToken, 1, true);
    }

    public GramikBot(String botToken, int threads) {
        this(botToken, threads, true);
    }

    public GramikBot(String botToken, boolean showUnfilteredUpdates) {
        this(botToken, 1, showUnfilteredUpdates);
    }

    public GramikBot(String botToken, int threadsNumber, boolean showUnfilteredUpdates) {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        this.executor = Executors.newFixedThreadPool(threadsNumber);
        this.url = "https://api.telegram.org/bot" + botToken + "/";
        this.showUnfilteredUpdates = false;
        Update[] arr = getUpdates();
        if (arr != null && arr.length > 0)
            this.lastUpdate = arr[arr.length - 1].updateId() + 1;
        this.showUnfilteredUpdates = showUnfilteredUpdates;
    }

    public void registerMessageFilter(Predicate<Message> filter, Consumer<Message> consumer) {
        this.filters.registerMessageFilter(filter, consumer);
    }

    public void registerBusinessMessageFilter(Predicate<Message> filter, Consumer<Message> consumer) {
        this.filters.registerBusinessMessageFilter(filter, consumer);
    }

    public void registerFilter(Predicate<Update> filter, Consumer<Update> consumer) {
        this.filters.registerUpdateFilter(filter, consumer);
    }

    public void registerChanelPostFilter(Predicate<Message> filter, Consumer<Message> consumer) {
        this.filters.registerChanelPostFilter(filter, consumer);
    }

    public void registerMessageOneTimeFilter(Predicate<Message> filter, Consumer<Message> consumer) {
        this.oneTimeFilters.registerMessageFilter(filter, consumer);
    }

    public void registerBusinessMessageOneTimeFilter(Predicate<Message> filter, Consumer<Message> consumer) {
        this.oneTimeFilters.registerBusinessMessageFilter(filter, consumer);
    }

    public void registerAnyMessagesFilter(Predicate<Message> filter, Consumer<Message> consumer) {
        this.filters.registerAnyMessagesFilter(filter, consumer);
    }

    public void registerOneTimeFilter(Predicate<Update> filter, Consumer<Update> consumer) {
        this.oneTimeFilters.registerUpdateFilter(filter, consumer);
    }

    public void registerOneTimeAnyMessagesFilter(Predicate<Message> filter, Consumer<Message> consumer) {
        this.oneTimeFilters.registerAnyMessagesFilter(filter, consumer);
    }

    public void registerOneTimeChanelPostFilter(Predicate<Message> filter, Consumer<Message> consumer) {
        this.oneTimeFilters.registerChanelPostFilter(filter, consumer);
    }

    public Update[] getUpdates() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(lastUpdate == 0 ? url + "getUpdates?" : url + "getUpdates?offset=" + lastUpdate)).GET().build();
        Update[] updates = null;
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            updates = objectMapper.readValue(parse(response.body()).get("result").toString(), Update[].class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (updates != null) {
            return updates;
        } else {
            throw new RuntimeException("SomethingWentWrongException");
        }
    }

    private JsonNode parse(String json) {
        try {
            return objectMapper.readTree(json);
        } catch (IOException e) {
            throw new RuntimeException("Error parsing JSON", e);
        }
    }

    public void sendMessage(long chatId, String text) {
        sendMessage(chatId, text, null, null, null, null);
    }

    public void sendMessage(long chatId, String text, ParseMode mode) {
        sendMessage(chatId, text, mode, null, null, null);
    }

    public void sendMessage(long chatId, String text, ReplyMarkup replyMarkup) {
        sendMessage(chatId, text, null, replyMarkup, null, null);
    }

    public void replyMessage(Message message, String text) {
        if (message.businessConnectionId() == null) {
            sendMessage(message.chat().id(), text, null, null,
                    new ReplyParameters(message.messageId(), null, null, null, null, null, null), null);
        } else {
            sendMessage(message.chat().id(), text, null, null,
                    new ReplyParameters(message.messageId(), null, null, null, null, null, null), message.businessConnectionId());
        }
    }

    public void sendMessage(long chatId, String text, ParseMode mode, ReplyMarkup replyMarkup, ReplyParameters replyParameters, String businessConnectionId) {
        try {
            ObjectNode jsonToSend = objectMapper.createObjectNode()
                    .put("chat_id", chatId)
                    .put("text", text);
            if (mode != null) {
                jsonToSend.put("parse_mode", mode.toString());
            }
            if (replyMarkup != null) {
                jsonToSend.put("reply_markup", replyMarkup.toJson());
            }
            if (replyParameters != null) {
                jsonToSend.put("reply_parameters", objectMapper.valueToTree(replyParameters));
            }
            if (businessConnectionId != null) {
                jsonToSend.put("business_connection_id", businessConnectionId);
            }

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url + "sendMessage"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonToSend.toString()))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new RuntimeException(response.body());
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void infinityPolling() {
        while (true) {
            final Update[] updates = getUpdates();
            if (updates == null || updates.length == 0) {
                continue;
            }
            lastUpdate = updates[updates.length - 1].updateId() + 1;
            for (final Update update : updates) {
                executor.execute(() -> {
                    if (!oneTimeFilters.consumeAndRemove(update) && !filters.consume(update) && showUnfilteredUpdates) {
                        System.err.println("Unfiltered update: " + update);
                    }
                });
            }
        }
    }
}

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Predicate;

import types.*;

public class GramikBot {
    private final String url;
    private final FilterContainer filters = new FilterContainer();
    private final FilterContainer oneTimeFilters = new FilterContainer();
    private final ExecutorService executor;
    private long lastUpdate = 0;
    private final boolean showUnfilteredUpdates;

    private final ObjectMapper objectMapper = new ObjectMapper();


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
        this.executor = Executors.newFixedThreadPool(threadsNumber);
        this.url = "https://api.telegram.org/bot" + botToken + "/";
        Update[] arr = getUpdates();
        if (arr != null && arr.length > 0)
            this.lastUpdate = arr[arr.length - 1].updateId() + 1;
        this.showUnfilteredUpdates = showUnfilteredUpdates;
    }

    public void registerMessageFilter(Predicate<Message> filter, Consumer<Message> consumer) {
        this.filters.registerMessageFilter(filter, consumer);
    }

    public void registerFilter(Predicate<Update> filter, Consumer<Update> consumer) {
        this.filters.registerUpdateFilter(filter, consumer);
    }

    public void registerMessageOneTimeFilter(Predicate<Message> filter, Consumer<Message> consumer) {
        this.oneTimeFilters.registerMessageFilter(filter, consumer);
    }

    public void registerOneTimeFilter(Predicate<Update> filter, Consumer<Update> consumer) {
        this.oneTimeFilters.registerUpdateFilter(filter, consumer);
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
        try {
            JsonNode jsonToSend = objectMapper.createObjectNode()
                    .put("chat_id", chatId)
                    .put("text", text);
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

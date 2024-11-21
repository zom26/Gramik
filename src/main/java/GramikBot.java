import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import types.*;

public class GramikBot {
    private final String url;
    private final Map<Predicate<Update>, Consumer<Update>> filterList = new LinkedHashMap<>();
    private final ExecutorService executor;
    private long lastUpdate = 0;

    private final ObjectMapper objectMapper = new ObjectMapper(); // Jackson ObjectMapper


    public GramikBot(String botToken) {
        this(botToken, 1);
    }

    public GramikBot(String botToken, int threadsNumber) {
        this.executor = Executors.newFixedThreadPool(threadsNumber);
        this.url = "https://api.telegram.org/bot" + botToken + "/";
        Update[] arr = getUpdates();
        if (arr != null && arr.length > 0)
            this.lastUpdate = arr[arr.length - 1].updateId() + 1;
    }
//
//    public void registerMessageFilter(Predicate<JsonNode> filter, Consumer<JsonNode> consumer) {
//        registerFilter(jsonNode -> filter.test(messageGetter.apply(jsonNode)),
//                jsonNode -> consumer.accept(messageGetter.apply(jsonNode)));
//    }

    public void registerFilter(Predicate<Update> filter, Consumer<Update> consumer) {
        this.filterList.put(filter, consumer);
    }

    public Update[] getUpdates() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(lastUpdate == 0 ? url + "getUpdates?" : url + "getUpdates?offset=" + lastUpdate)).GET().build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(parse(response.body()).get("result").toString(), Update[].class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private JsonNode parse(String json) {
        try {
            return objectMapper.readTree(json); // Используем Jackson для парсинга
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
            if (updates != null && updates.length > 0)
                lastUpdate = updates[updates.length - 1].updateId() + 1;
            for (int i = 0; i < updates.length; i++) {
                final Update update = updates[i];
                executor.execute(() -> {
                    for (Map.Entry<Predicate<Update>, Consumer<Update>> entry : filterList.entrySet()) {
                        if (entry.getKey().test(update)) {
                            entry.getValue().accept(update);
                            break;
                        }
                    }
                });
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

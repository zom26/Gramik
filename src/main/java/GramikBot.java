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

public class GramikBot {
    private final String url;
    private final Map<Predicate<JsonNode>, Consumer<JsonNode>> filterList = new LinkedHashMap<>();
    private final ExecutorService executor;
    private long lastUpdate = 0;

    private final ObjectMapper objectMapper = new ObjectMapper(); // Jackson ObjectMapper

    public GramikBot(String botToken) {
        this(botToken, 8);
    }

    public GramikBot(String botToken, int threadsNumber) {
        this.executor = Executors.newFixedThreadPool(threadsNumber);
        this.url = "https://api.telegram.org/bot" + botToken + "/";
        JsonNode arr = getUpdates();
        if (!arr.isEmpty())
            this.lastUpdate = arr.get(arr.size() - 1).get("update_id").asLong() + 1;
    }

    public void registerFilter(Predicate<JsonNode> filter, Consumer<JsonNode> consumer) {
        this.filterList.put(filter, consumer);
    }

    public JsonNode getUpdates() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(lastUpdate == 0 ? url + "getUpdates?" : url + "getUpdates?offset=" + lastUpdate)).GET().build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return parse(response.body()).get("result");
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
            final JsonNode updates = getUpdates();
            if (!updates.isEmpty())
                lastUpdate = updates.get(updates.size() - 1).get("update_id").asLong() + 1;
            for (int i = 0; i < updates.size(); i++) {
                final JsonNode update = updates.get(i);
                executor.execute(() -> {
                    for (Map.Entry<Predicate<JsonNode>, Consumer<JsonNode>> entry : filterList.entrySet()) {
                        if (entry.getKey().test(update)) {
                            entry.getValue().accept(update);
                            break;
                        }
                    }
                });
            }
        }
    }
}

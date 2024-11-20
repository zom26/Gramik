package types;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.function.Predicate;

public class UpdatesFilters {

    static public Predicate<JsonNode> always() {
        return (x) -> true;
    }

    static public Predicate<JsonNode> messageFilter() {
        return jsonNode -> jsonNode.has("message");
    }

    static public Predicate<JsonNode> textMessageFilter() {
        return messageFilter().and(jsonNode -> jsonNode.get("message").has("text"));
    }

    static public Predicate<JsonNode> commandFilter(String command) {
        return textMessageFilter()
                .and(jsonNode -> jsonNode.get("message").get("text").asText().startsWith(command));
    }

}

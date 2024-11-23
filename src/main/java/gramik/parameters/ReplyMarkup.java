package gramik.parameters;

import com.fasterxml.jackson.databind.JsonNode;

public interface ReplyMarkup {
    JsonNode toJson();
}

package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import gramik.GramikBot;
import gramik.parameters.ReplyMarkup;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ReplyKeyboardMarkup(
    @JsonProperty("keyboard")
    KeyboardButton[][] keyboard,

    @JsonProperty("is_persistent")
    Boolean isPersistent,

    @JsonProperty("resize_keyboard")
    Boolean resizeKeyboard,

    @JsonProperty("one_time_keyboard")
    Boolean oneTimeKeyboard,

    @JsonProperty("input_field_placeholder")
    String inputFieldPlaceholder,

    @JsonProperty("selective")
    Boolean selective
) implements ReplyMarkup {
    public ReplyKeyboardMarkup(KeyboardButton[][] keyboard) {
        this(keyboard, null, null, null, "", null);
    }

    public static record Remove(
            Boolean selective
    ) implements ReplyMarkup {
        public Remove() {
            this(null);
        }
        @Override
        public JsonNode toJson() {
            ObjectNode node = GramikBot.objectMapper.valueToTree(this);
            node.put("remove_keyboard", true);
            return node;
        }
    }


    @Override
    public JsonNode toJson() {
        return GramikBot.objectMapper.valueToTree(this);
    }
}

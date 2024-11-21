package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ReplyKeyboardMarkup (
    @JsonProperty("keyboard")
    KeyboardButton[] keyboard,

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
) {}

package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InlineQueryResultGame (
    @JsonProperty("type")
    String type,

    @JsonProperty("id")
    String id,

    @JsonProperty("game_short_name")
    String gameShortName,

    @JsonProperty("reply_markup")
    InlineKeyboardMarkup replyMarkup
) {}

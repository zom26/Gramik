package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CallbackQuery (
    @JsonProperty("id")
    String id,

    @JsonProperty("from")
    User from,

    @JsonProperty("message")
    MaybeInaccessibleMessage message,

    @JsonProperty("inline_message_id")
    String inlineMessageId,

    @JsonProperty("chat_instance")
    String chatInstance,

    @JsonProperty("data")
    String data,

    @JsonProperty("game_short_name")
    String gameShortName
) {}

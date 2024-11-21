package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ReplyParameters (
    @JsonProperty("message_id")
    Long messageId,

    @JsonProperty("chat_id")
    Long chatId,

    @JsonProperty("allow_sending_without_reply")
    Boolean allowSendingWithoutReply,

    @JsonProperty("quote")
    String quote,

    @JsonProperty("quote_parse_mode")
    String quoteParseMode,

    @JsonProperty("quote_entities")
    MessageEntity[] quoteEntities,

    @JsonProperty("quote_position")
    Long quotePosition
) {}

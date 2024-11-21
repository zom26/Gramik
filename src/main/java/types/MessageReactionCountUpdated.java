package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MessageReactionCountUpdated (
    @JsonProperty("chat")
    Chat chat,

    @JsonProperty("message_id")
    Long messageId,

    @JsonProperty("date")
    Long date,

    @JsonProperty("reactions")
    ReactionCount[] reactions
) {}

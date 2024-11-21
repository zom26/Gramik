package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MessageReactionUpdated (
    @JsonProperty("chat")
    Chat chat,

    @JsonProperty("message_id")
    Long messageId,

    @JsonProperty("user")
    User user,

    @JsonProperty("actor_chat")
    Chat actorChat,

    @JsonProperty("date")
    Long date,

    @JsonProperty("old_reaction")
    ReactionType[] oldReaction,

    @JsonProperty("new_reaction")
    ReactionType[] newReaction
) {}

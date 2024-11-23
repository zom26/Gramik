package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ChatJoinRequest (
    @JsonProperty("chat")
    Chat chat,

    @JsonProperty("from")
    User from,

    @JsonProperty("user_chat_id")
    Long userChatId,

    @JsonProperty("date")
    Long date,

    @JsonProperty("bio")
    String bio,

    @JsonProperty("invite_link")
    ChatInviteLink inviteLink
) {}

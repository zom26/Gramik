package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ChatMemberUpdated (
    @JsonProperty("chat")
    Chat chat,

    @JsonProperty("from")
    User from,

    @JsonProperty("date")
    Long date,

    @JsonProperty("old_chat_member")
    ChatMember oldChatMember,

    @JsonProperty("new_chat_member")
    ChatMember newChatMember,

    @JsonProperty("invite_link")
    ChatInviteLink inviteLink,

    @JsonProperty("via_join_request")
    Boolean viaJoinRequest,

    @JsonProperty("via_chat_folder_invite_link")
    Boolean viaChatFolderInviteLink
) {}

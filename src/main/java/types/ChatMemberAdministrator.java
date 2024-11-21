package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ChatMemberAdministrator (
    @JsonProperty("status")
    String status,

    @JsonProperty("user")
    User user,

    @JsonProperty("can_be_edited")
    Boolean canBeEdited,

    @JsonProperty("is_anonymous")
    Boolean isAnonymous,

    @JsonProperty("can_manage_chat")
    Boolean canManageChat,

    @JsonProperty("can_delete_messages")
    Boolean canDeleteMessages,

    @JsonProperty("can_manage_video_chats")
    Boolean canManageVideoChats,

    @JsonProperty("can_restrict_members")
    Boolean canRestrictMembers,

    @JsonProperty("can_promote_members")
    Boolean canPromoteMembers,

    @JsonProperty("can_change_info")
    Boolean canChangeInfo,

    @JsonProperty("can_invite_users")
    Boolean canInviteUsers,

    @JsonProperty("can_post_stories")
    Boolean canPostStories,

    @JsonProperty("can_edit_stories")
    Boolean canEditStories,

    @JsonProperty("can_delete_stories")
    Boolean canDeleteStories,

    @JsonProperty("can_post_messages")
    Boolean canPostMessages,

    @JsonProperty("can_edit_messages")
    Boolean canEditMessages,

    @JsonProperty("can_pin_messages")
    Boolean canPinMessages,

    @JsonProperty("can_manage_topics")
    Boolean canManageTopics,

    @JsonProperty("custom_title")
    String customTitle
) {}

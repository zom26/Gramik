package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ChatMemberRestricted (
    @JsonProperty("status")
    String status,

    @JsonProperty("user")
    User user,

    @JsonProperty("is_member")
    Boolean isMember,

    @JsonProperty("can_send_messages")
    Boolean canSendMessages,

    @JsonProperty("can_send_audios")
    Boolean canSendAudios,

    @JsonProperty("can_send_documents")
    Boolean canSendDocuments,

    @JsonProperty("can_send_photos")
    Boolean canSendPhotos,

    @JsonProperty("can_send_videos")
    Boolean canSendVideos,

    @JsonProperty("can_send_video_notes")
    Boolean canSendVideoNotes,

    @JsonProperty("can_send_voice_notes")
    Boolean canSendVoiceNotes,

    @JsonProperty("can_send_polls")
    Boolean canSendPolls,

    @JsonProperty("can_send_other_messages")
    Boolean canSendOtherMessages,

    @JsonProperty("can_add_web_page_previews")
    Boolean canAddWebPagePreviews,

    @JsonProperty("can_change_info")
    Boolean canChangeInfo,

    @JsonProperty("can_invite_users")
    Boolean canInviteUsers,

    @JsonProperty("can_pin_messages")
    Boolean canPinMessages,

    @JsonProperty("can_manage_topics")
    Boolean canManageTopics,

    @JsonProperty("until_date")
    Long untilDate
) {}

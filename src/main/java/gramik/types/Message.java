package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Message (
    @JsonProperty("message_id")
    Long messageId,

    @JsonProperty("message_thread_id")
    Long messageThreadId,

    @JsonProperty("from")
    User from,

    @JsonProperty("sender_chat")
    Chat senderChat,

    @JsonProperty("sender_boost_count")
    Long senderBoostCount,

    @JsonProperty("sender_business_bot")
    User senderBusinessBot,

    @JsonProperty("date")
    Long date,

    @JsonProperty("business_connection_id")
    String businessConnectionId,

    @JsonProperty("chat")
    Chat chat,

    @JsonProperty("forward_origin")
    MessageOrigin forwardOrigin,

    @JsonProperty("is_topic_message")
    Boolean isTopicMessage,

    @JsonProperty("is_automatic_forward")
    Boolean isAutomaticForward,

    @JsonProperty("reply_to_message")
    Message replyToMessage,

    @JsonProperty("external_reply")
    ExternalReplyInfo externalReply,

    @JsonProperty("quote")
    TextQuote quote,

    @JsonProperty("reply_to_story")
    Story replyToStory,

    @JsonProperty("via_bot")
    User viaBot,

    @JsonProperty("edit_date")
    Long editDate,

    @JsonProperty("has_protected_content")
    Boolean hasProtectedContent,

    @JsonProperty("is_from_offline")
    Boolean isFromOffline,

    @JsonProperty("media_group_id")
    String mediaGroupId,

    @JsonProperty("author_signature")
    String authorSignature,

    @JsonProperty("text")
    String text,

    @JsonProperty("entities")
    MessageEntity[] entities,

    @JsonProperty("link_preview_options")
    LinkPreviewOptions linkPreviewOptions,

    @JsonProperty("effect_id")
    String effectId,

    @JsonProperty("animation")
    Animation animation,

    @JsonProperty("audio")
    Audio audio,

    @JsonProperty("document")
    Document document,

    @JsonProperty("paid_media")
    PaidMediaInfo paidMedia,

    @JsonProperty("photo")
    PhotoSize[] photo,

    @JsonProperty("sticker")
    Sticker sticker,

    @JsonProperty("story")
    Story story,

    @JsonProperty("video")
    Video video,

    @JsonProperty("video_note")
    VideoNote videoNote,

    @JsonProperty("voice")
    Voice voice,

    @JsonProperty("caption")
    String caption,

    @JsonProperty("caption_entities")
    MessageEntity[] captionEntities,

    @JsonProperty("show_caption_above_media")
    Boolean showCaptionAboveMedia,

    @JsonProperty("has_media_spoiler")
    Boolean hasMediaSpoiler,

    @JsonProperty("contact")
    Contact contact,

    @JsonProperty("dice")
    Dice dice,

    @JsonProperty("game")
    Game game,

    @JsonProperty("poll")
    Poll poll,

    @JsonProperty("venue")
    Venue venue,

    @JsonProperty("location")
    Location location,

    @JsonProperty("new_chat_members")
    User[] newChatMembers,

    @JsonProperty("left_chat_member")
    User leftChatMember,

    @JsonProperty("new_chat_title")
    String newChatTitle,

    @JsonProperty("new_chat_photo")
    PhotoSize[] newChatPhoto,

    @JsonProperty("delete_chat_photo")
    Boolean deleteChatPhoto,

    @JsonProperty("group_chat_created")
    Boolean groupChatCreated,

    @JsonProperty("supergroup_chat_created")
    Boolean supergroupChatCreated,

    @JsonProperty("channel_chat_created")
    Boolean channelChatCreated,

    @JsonProperty("message_auto_delete_timer_changed")
    MessageAutoDeleteTimerChanged messageAutoDeleteTimerChanged,

    @JsonProperty("migrate_to_chat_id")
    Long migrateToChatId,

    @JsonProperty("migrate_from_chat_id")
    Long migrateFromChatId,

    @JsonProperty("pinned_message")
    MaybeInaccessibleMessage pinnedMessage,

    @JsonProperty("invoice")
    Invoice invoice,

    @JsonProperty("successful_payment")
    SuccessfulPayment successfulPayment,

    @JsonProperty("refunded_payment")
    RefundedPayment refundedPayment,

    @JsonProperty("users_shared")
    UsersShared usersShared,

    @JsonProperty("chat_shared")
    ChatShared chatShared,

    @JsonProperty("connected_website")
    String connectedWebsite,

    @JsonProperty("write_access_allowed")
    WriteAccessAllowed writeAccessAllowed,

    @JsonProperty("passport_data")
    PassportData passportData,

    @JsonProperty("proximity_alert_triggered")
    ProximityAlertTriggered proximityAlertTriggered,

    @JsonProperty("boost_added")
    ChatBoostAdded boostAdded,

    @JsonProperty("chat_background_set")
    ChatBackground chatBackgroundSet,

    @JsonProperty("forum_topic_created")
    ForumTopicCreated forumTopicCreated,

    @JsonProperty("forum_topic_edited")
    ForumTopicEdited forumTopicEdited,

    @JsonProperty("forum_topic_closed")
    ForumTopicClosed forumTopicClosed,

    @JsonProperty("forum_topic_reopened")
    ForumTopicReopened forumTopicReopened,

    @JsonProperty("general_forum_topic_hidden")
    GeneralForumTopicHidden generalForumTopicHidden,

    @JsonProperty("general_forum_topic_unhidden")
    GeneralForumTopicUnhidden generalForumTopicUnhidden,

    @JsonProperty("giveaway_created")
    GiveawayCreated giveawayCreated,

    @JsonProperty("giveaway")
    Giveaway giveaway,

    @JsonProperty("giveaway_winners")
    GiveawayWinners giveawayWinners,

    @JsonProperty("giveaway_completed")
    GiveawayCompleted giveawayCompleted,

    @JsonProperty("video_chat_scheduled")
    VideoChatScheduled videoChatScheduled,

    @JsonProperty("video_chat_started")
    VideoChatStarted videoChatStarted,

    @JsonProperty("video_chat_ended")
    VideoChatEnded videoChatEnded,

    @JsonProperty("video_chat_participants_invited")
    VideoChatParticipantsInvited videoChatParticipantsInvited,

    @JsonProperty("web_app_data")
    WebAppData webAppData,

    @JsonProperty("reply_markup")
    InlineKeyboardMarkup replyMarkup
) {}

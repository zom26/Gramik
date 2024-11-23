package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ChatFullInfo (
    @JsonProperty("id")
    Long id,

    @JsonProperty("type")
    String type,

    @JsonProperty("title")
    String title,

    @JsonProperty("username")
    String username,

    @JsonProperty("first_name")
    String firstName,

    @JsonProperty("last_name")
    String lastName,

    @JsonProperty("is_forum")
    Boolean isForum,

    @JsonProperty("accent_color_id")
    Long accentColorId,

    @JsonProperty("max_reaction_count")
    Long maxReactionCount,

    @JsonProperty("photo")
    ChatPhoto photo,

    @JsonProperty("active_usernames")
    String[] activeUsernames,

    @JsonProperty("birthdate")
    Birthdate birthdate,

    @JsonProperty("business_intro")
    BusinessIntro businessIntro,

    @JsonProperty("business_location")
    BusinessLocation businessLocation,

    @JsonProperty("business_opening_hours")
    BusinessOpeningHours businessOpeningHours,

    @JsonProperty("personal_chat")
    Chat personalChat,

    @JsonProperty("available_reactions")
    ReactionType[] availableReactions,

    @JsonProperty("background_custom_emoji_id")
    String backgroundCustomEmojiId,

    @JsonProperty("profile_accent_color_id")
    Long profileAccentColorId,

    @JsonProperty("profile_background_custom_emoji_id")
    String profileBackgroundCustomEmojiId,

    @JsonProperty("emoji_status_custom_emoji_id")
    String emojiStatusCustomEmojiId,

    @JsonProperty("emoji_status_expiration_date")
    Long emojiStatusExpirationDate,

    @JsonProperty("bio")
    String bio,

    @JsonProperty("has_private_forwards")
    Boolean hasPrivateForwards,

    @JsonProperty("has_restricted_voice_and_video_messages")
    Boolean hasRestrictedVoiceAndVideoMessages,

    @JsonProperty("join_to_send_messages")
    Boolean joinToSendMessages,

    @JsonProperty("join_by_request")
    Boolean joinByRequest,

    @JsonProperty("description")
    String description,

    @JsonProperty("invite_link")
    String inviteLink,

    @JsonProperty("pinned_message")
    Message pinnedMessage,

    @JsonProperty("permissions")
    ChatPermissions permissions,

    @JsonProperty("can_send_paid_media")
    Boolean canSendPaidMedia,

    @JsonProperty("slow_mode_delay")
    Long slowModeDelay,

    @JsonProperty("unrestrict_boost_count")
    Long unrestrictBoostCount,

    @JsonProperty("message_auto_delete_time")
    Long messageAutoDeleteTime,

    @JsonProperty("has_aggressive_anti_spam_enabled")
    Boolean hasAggressiveAntiSpamEnabled,

    @JsonProperty("has_hidden_members")
    Boolean hasHiddenMembers,

    @JsonProperty("has_protected_content")
    Boolean hasProtectedContent,

    @JsonProperty("has_visible_history")
    Boolean hasVisibleHistory,

    @JsonProperty("sticker_set_name")
    String stickerSetName,

    @JsonProperty("can_set_sticker_set")
    Boolean canSetStickerSet,

    @JsonProperty("custom_emoji_sticker_set_name")
    String customEmojiStickerSetName,

    @JsonProperty("linked_chat_id")
    Long linkedChatId,

    @JsonProperty("location")
    ChatLocation location
) {}

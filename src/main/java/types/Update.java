package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Update (
    @JsonProperty("update_id")
    Long updateId,

    @JsonProperty("message")
    Message message,

    @JsonProperty("edited_message")
    Message editedMessage,

    @JsonProperty("channel_post")
    Message channelPost,

    @JsonProperty("edited_channel_post")
    Message editedChannelPost,

    @JsonProperty("business_connection")
    BusinessConnection businessConnection,

    @JsonProperty("business_message")
    Message businessMessage,

    @JsonProperty("edited_business_message")
    Message editedBusinessMessage,

    @JsonProperty("deleted_business_messages")
    BusinessMessagesDeleted deletedBusinessMessages,

    @JsonProperty("message_reaction")
    MessageReactionUpdated messageReaction,

    @JsonProperty("message_reaction_count")
    MessageReactionCountUpdated messageReactionCount,

    @JsonProperty("inline_query")
    InlineQuery inlineQuery,

    @JsonProperty("chosen_inline_result")
    ChosenInlineResult chosenInlineResult,

    @JsonProperty("callback_query")
    CallbackQuery callbackQuery,

    @JsonProperty("shipping_query")
    ShippingQuery shippingQuery,

    @JsonProperty("pre_checkout_query")
    PreCheckoutQuery preCheckoutQuery,

    @JsonProperty("purchased_paid_media")
    PaidMediaPurchased purchasedPaidMedia,

    @JsonProperty("poll")
    Poll poll,

    @JsonProperty("poll_answer")
    PollAnswer pollAnswer,

    @JsonProperty("my_chat_member")
    ChatMemberUpdated myChatMember,

    @JsonProperty("chat_member")
    ChatMemberUpdated chatMember,

    @JsonProperty("chat_join_request")
    ChatJoinRequest chatJoinRequest,

    @JsonProperty("chat_boost")
    ChatBoostUpdated chatBoost,

    @JsonProperty("removed_chat_boost")
    ChatBoostRemoved removedChatBoost
) {}

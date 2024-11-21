package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GiveawayWinners (
    @JsonProperty("chat")
    Chat chat,

    @JsonProperty("giveaway_message_id")
    Long giveawayMessageId,

    @JsonProperty("winners_selection_date")
    Long winnersSelectionDate,

    @JsonProperty("winner_count")
    Long winnerCount,

    @JsonProperty("winners")
    User[] winners,

    @JsonProperty("additional_chat_count")
    Long additionalChatCount,

    @JsonProperty("prize_star_count")
    Long prizeStarCount,

    @JsonProperty("premium_subscription_month_count")
    Long premiumSubscriptionMonthCount,

    @JsonProperty("unclaimed_prize_count")
    Long unclaimedPrizeCount,

    @JsonProperty("only_new_members")
    Boolean onlyNewMembers,

    @JsonProperty("was_refunded")
    Boolean wasRefunded,

    @JsonProperty("prize_description")
    String prizeDescription
) {}

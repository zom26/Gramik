package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Giveaway (
    @JsonProperty("chats")
    Chat[] chats,

    @JsonProperty("winners_selection_date")
    Long winnersSelectionDate,

    @JsonProperty("winner_count")
    Long winnerCount,

    @JsonProperty("only_new_members")
    Boolean onlyNewMembers,

    @JsonProperty("has_public_winners")
    Boolean hasPublicWinners,

    @JsonProperty("prize_description")
    String prizeDescription,

    @JsonProperty("country_codes")
    String[] countryCodes,

    @JsonProperty("prize_star_count")
    Long prizeStarCount,

    @JsonProperty("premium_subscription_month_count")
    Long premiumSubscriptionMonthCount
) {}

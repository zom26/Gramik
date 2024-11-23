package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GiveawayCompleted (
    @JsonProperty("winner_count")
    Long winnerCount,

    @JsonProperty("unclaimed_prize_count")
    Long unclaimedPrizeCount,

    @JsonProperty("giveaway_message")
    Message giveawayMessage,

    @JsonProperty("is_star_giveaway")
    Boolean isStarGiveaway
) {}

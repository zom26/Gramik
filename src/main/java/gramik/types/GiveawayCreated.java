package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GiveawayCreated (
    @JsonProperty("prize_star_count")
    Long prizeStarCount
) {}

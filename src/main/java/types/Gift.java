package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Gift (
    @JsonProperty("id")
    String id,

    @JsonProperty("sticker")
    Sticker sticker,

    @JsonProperty("star_count")
    Long starCount,

    @JsonProperty("total_count")
    Long totalCount,

    @JsonProperty("remaining_count")
    Long remainingCount
) {}

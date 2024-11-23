package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PaidMediaInfo (
    @JsonProperty("star_count")
    Long starCount,

    @JsonProperty("paid_media")
    PaidMedia[] paidMedia
) {}

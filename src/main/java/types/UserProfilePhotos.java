package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UserProfilePhotos (
    @JsonProperty("total_count")
    Long totalCount,

    @JsonProperty("photos")
    PhotoSize[] photos
) {}

package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LinkPreviewOptions (
    @JsonProperty("is_disabled")
    Boolean isDisabled,

    @JsonProperty("url")
    String url,

    @JsonProperty("prefer_small_media")
    Boolean preferSmallMedia,

    @JsonProperty("prefer_large_media")
    Boolean preferLargeMedia,

    @JsonProperty("show_above_text")
    Boolean showAboveText
) {}

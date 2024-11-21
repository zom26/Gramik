package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InputMediaVideo (
    @JsonProperty("type")
    String type,

    @JsonProperty("media")
    String media,

    @JsonProperty("thumbnail")
    String thumbnail,

    @JsonProperty("caption")
    String caption,

    @JsonProperty("parse_mode")
    String parseMode,

    @JsonProperty("caption_entities")
    MessageEntity[] captionEntities,

    @JsonProperty("show_caption_above_media")
    Boolean showCaptionAboveMedia,

    @JsonProperty("width")
    Long width,

    @JsonProperty("height")
    Long height,

    @JsonProperty("duration")
    Long duration,

    @JsonProperty("supports_streaming")
    Boolean supportsStreaming,

    @JsonProperty("has_spoiler")
    Boolean hasSpoiler
) {}

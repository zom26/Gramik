package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InputMediaAudio (
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

    @JsonProperty("duration")
    Long duration,

    @JsonProperty("performer")
    String performer,

    @JsonProperty("title")
    String title
) {}

package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InputSticker (
    @JsonProperty("sticker")
    String sticker,

    @JsonProperty("format")
    String format,

    @JsonProperty("emoji_list")
    String[] emojiList,

    @JsonProperty("mask_position")
    MaskPosition maskPosition,

    @JsonProperty("keywords")
    String[] keywords
) {}

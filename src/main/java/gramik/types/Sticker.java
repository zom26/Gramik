package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Sticker (
    @JsonProperty("file_id")
    String fileId,

    @JsonProperty("file_unique_id")
    String fileUniqueId,

    @JsonProperty("type")
    String type,

    @JsonProperty("width")
    Long width,

    @JsonProperty("height")
    Long height,

    @JsonProperty("is_animated")
    Boolean isAnimated,

    @JsonProperty("is_video")
    Boolean isVideo,

    @JsonProperty("thumbnail")
    PhotoSize thumbnail,

    @JsonProperty("emoji")
    String emoji,

    @JsonProperty("set_name")
    String setName,

    @JsonProperty("premium_animation")
    File premiumAnimation,

    @JsonProperty("mask_position")
    MaskPosition maskPosition,

    @JsonProperty("custom_emoji_id")
    String customEmojiId,

    @JsonProperty("needs_repainting")
    Boolean needsRepainting,

    @JsonProperty("file_size")
    Long fileSize
) {}

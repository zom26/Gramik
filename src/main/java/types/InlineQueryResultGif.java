package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InlineQueryResultGif (
    @JsonProperty("type")
    String type,

    @JsonProperty("id")
    String id,

    @JsonProperty("gif_url")
    String gifUrl,

    @JsonProperty("gif_width")
    Long gifWidth,

    @JsonProperty("gif_height")
    Long gifHeight,

    @JsonProperty("gif_duration")
    Long gifDuration,

    @JsonProperty("thumbnail_url")
    String thumbnailUrl,

    @JsonProperty("thumbnail_mime_type")
    String thumbnailMimeType,

    @JsonProperty("title")
    String title,

    @JsonProperty("caption")
    String caption,

    @JsonProperty("parse_mode")
    String parseMode,

    @JsonProperty("caption_entities")
    MessageEntity[] captionEntities,

    @JsonProperty("show_caption_above_media")
    Boolean showCaptionAboveMedia,

    @JsonProperty("reply_markup")
    InlineKeyboardMarkup replyMarkup,

    @JsonProperty("input_message_content")
    InputMessageContent inputMessageContent
) {}

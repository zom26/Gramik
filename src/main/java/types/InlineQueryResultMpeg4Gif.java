package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InlineQueryResultMpeg4Gif (
    @JsonProperty("type")
    String type,

    @JsonProperty("id")
    String id,

    @JsonProperty("mpeg4_url")
    String mpeg4Url,

    @JsonProperty("mpeg4_width")
    Long mpeg4Width,

    @JsonProperty("mpeg4_height")
    Long mpeg4Height,

    @JsonProperty("mpeg4_duration")
    Long mpeg4Duration,

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

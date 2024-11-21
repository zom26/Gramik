package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InlineQueryResultVideo (
    @JsonProperty("type")
    String type,

    @JsonProperty("id")
    String id,

    @JsonProperty("video_url")
    String videoUrl,

    @JsonProperty("mime_type")
    String mimeType,

    @JsonProperty("thumbnail_url")
    String thumbnailUrl,

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

    @JsonProperty("video_width")
    Long videoWidth,

    @JsonProperty("video_height")
    Long videoHeight,

    @JsonProperty("video_duration")
    Long videoDuration,

    @JsonProperty("description")
    String description,

    @JsonProperty("reply_markup")
    InlineKeyboardMarkup replyMarkup,

    @JsonProperty("input_message_content")
    InputMessageContent inputMessageContent
) {}

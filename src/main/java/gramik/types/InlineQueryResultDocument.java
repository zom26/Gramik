package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InlineQueryResultDocument (
    @JsonProperty("type")
    String type,

    @JsonProperty("id")
    String id,

    @JsonProperty("title")
    String title,

    @JsonProperty("caption")
    String caption,

    @JsonProperty("parse_mode")
    String parseMode,

    @JsonProperty("caption_entities")
    MessageEntity[] captionEntities,

    @JsonProperty("document_url")
    String documentUrl,

    @JsonProperty("mime_type")
    String mimeType,

    @JsonProperty("description")
    String description,

    @JsonProperty("reply_markup")
    InlineKeyboardMarkup replyMarkup,

    @JsonProperty("input_message_content")
    InputMessageContent inputMessageContent,

    @JsonProperty("thumbnail_url")
    String thumbnailUrl,

    @JsonProperty("thumbnail_width")
    Long thumbnailWidth,

    @JsonProperty("thumbnail_height")
    Long thumbnailHeight
) {}

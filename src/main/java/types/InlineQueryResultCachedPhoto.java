package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InlineQueryResultCachedPhoto (
    @JsonProperty("type")
    String type,

    @JsonProperty("id")
    String id,

    @JsonProperty("photo_file_id")
    String photoFileId,

    @JsonProperty("title")
    String title,

    @JsonProperty("description")
    String description,

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

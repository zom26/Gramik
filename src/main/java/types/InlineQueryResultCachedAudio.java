package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InlineQueryResultCachedAudio (
    @JsonProperty("type")
    String type,

    @JsonProperty("id")
    String id,

    @JsonProperty("audio_file_id")
    String audioFileId,

    @JsonProperty("caption")
    String caption,

    @JsonProperty("parse_mode")
    String parseMode,

    @JsonProperty("caption_entities")
    MessageEntity[] captionEntities,

    @JsonProperty("reply_markup")
    InlineKeyboardMarkup replyMarkup,

    @JsonProperty("input_message_content")
    InputMessageContent inputMessageContent
) {}

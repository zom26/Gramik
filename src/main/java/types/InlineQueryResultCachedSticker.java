package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InlineQueryResultCachedSticker (
    @JsonProperty("type")
    String type,

    @JsonProperty("id")
    String id,

    @JsonProperty("sticker_file_id")
    String stickerFileId,

    @JsonProperty("reply_markup")
    InlineKeyboardMarkup replyMarkup,

    @JsonProperty("input_message_content")
    InputMessageContent inputMessageContent
) {}

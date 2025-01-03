package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InlineQueryResultVoice (
    @JsonProperty("type")
    String type,

    @JsonProperty("id")
    String id,

    @JsonProperty("voice_url")
    String voiceUrl,

    @JsonProperty("title")
    String title,

    @JsonProperty("caption")
    String caption,

    @JsonProperty("parse_mode")
    String parseMode,

    @JsonProperty("caption_entities")
    MessageEntity[] captionEntities,

    @JsonProperty("voice_duration")
    Long voiceDuration,

    @JsonProperty("reply_markup")
    InlineKeyboardMarkup replyMarkup,

    @JsonProperty("input_message_content")
    InputMessageContent inputMessageContent
) {}

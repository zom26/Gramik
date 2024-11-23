package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InlineQueryResult (
    @JsonProperty("type")
    String type,

    @JsonProperty("id")
    String id,

    @JsonProperty("title")
    String title,

    @JsonProperty("input_message_content")
    InputMessageContent inputMessageContent,

    @JsonProperty("reply_markup")
    InlineKeyboardMarkup replyMarkup,

    @JsonProperty("url")
    String url,

    @JsonProperty("hide_url")
    Boolean hideUrl,

    @JsonProperty("description")
    String description,

    @JsonProperty("thumbnail_url")
    String thumbnailUrl,

    @JsonProperty("thumbnail_width")
    Long thumbnailWidth,

    @JsonProperty("thumbnail_height")
    Long thumbnailHeight
) {}

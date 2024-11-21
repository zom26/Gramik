package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InlineQueryResultContact (
    @JsonProperty("type")
    String type,

    @JsonProperty("id")
    String id,

    @JsonProperty("phone_number")
    String phoneNumber,

    @JsonProperty("first_name")
    String firstName,

    @JsonProperty("last_name")
    String lastName,

    @JsonProperty("vcard")
    String vcard,

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

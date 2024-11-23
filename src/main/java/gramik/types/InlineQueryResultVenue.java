package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InlineQueryResultVenue (
    @JsonProperty("type")
    String type,

    @JsonProperty("id")
    String id,

    @JsonProperty("latitude")
    Double latitude,

    @JsonProperty("longitude")
    Double longitude,

    @JsonProperty("title")
    String title,

    @JsonProperty("address")
    String address,

    @JsonProperty("foursquare_id")
    String foursquareId,

    @JsonProperty("foursquare_type")
    String foursquareType,

    @JsonProperty("google_place_id")
    String googlePlaceId,

    @JsonProperty("google_place_type")
    String googlePlaceType,

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

package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InlineQueryResultLocation (
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

    @JsonProperty("horizontal_accuracy")
    Double horizontalAccuracy,

    @JsonProperty("live_period")
    Long livePeriod,

    @JsonProperty("heading")
    Long heading,

    @JsonProperty("proximity_alert_radius")
    Long proximityAlertRadius,

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

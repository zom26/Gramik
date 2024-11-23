package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InputLocationMessageContent (
    @JsonProperty("latitude")
    Double latitude,

    @JsonProperty("longitude")
    Double longitude,

    @JsonProperty("horizontal_accuracy")
    Double horizontalAccuracy,

    @JsonProperty("live_period")
    Long livePeriod,

    @JsonProperty("heading")
    Long heading,

    @JsonProperty("proximity_alert_radius")
    Long proximityAlertRadius
) {}

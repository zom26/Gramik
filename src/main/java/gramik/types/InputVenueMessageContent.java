package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InputVenueMessageContent (
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
    String googlePlaceType
) {}

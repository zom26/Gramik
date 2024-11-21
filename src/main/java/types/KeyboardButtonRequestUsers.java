package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record KeyboardButtonRequestUsers (
    @JsonProperty("request_id")
    Long requestId,

    @JsonProperty("user_is_bot")
    Boolean userIsBot,

    @JsonProperty("user_is_premium")
    Boolean userIsPremium,

    @JsonProperty("max_quantity")
    Long maxQuantity,

    @JsonProperty("request_name")
    Boolean requestName,

    @JsonProperty("request_username")
    Boolean requestUsername,

    @JsonProperty("request_photo")
    Boolean requestPhoto
) {}

package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ChatBoost (
    @JsonProperty("boost_id")
    String boostId,

    @JsonProperty("add_date")
    Long addDate,

    @JsonProperty("expiration_date")
    Long expirationDate,

    @JsonProperty("source")
    ChatBoostSource source
) {}

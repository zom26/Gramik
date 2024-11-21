package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ChatBoostSource (
    @JsonProperty("source")
    String source,

    @JsonProperty("user")
    User user
) {}

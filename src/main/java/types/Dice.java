package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Dice (
    @JsonProperty("emoji")
    String emoji,

    @JsonProperty("value")
    Long value
) {}

package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GameHighScore (
    @JsonProperty("position")
    Long position,

    @JsonProperty("user")
    User user,

    @JsonProperty("score")
    Long score
) {}

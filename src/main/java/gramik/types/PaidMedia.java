package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PaidMedia (
    @JsonProperty("type")
    String type,

    @JsonProperty("width")
    Long width,

    @JsonProperty("height")
    Long height,

    @JsonProperty("duration")
    Long duration
) {}

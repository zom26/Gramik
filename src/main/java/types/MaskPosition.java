package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MaskPosition (
    @JsonProperty("point")
    String point,

    @JsonProperty("x_shift")
    Double xShift,

    @JsonProperty("y_shift")
    Double yShift,

    @JsonProperty("scale")
    Double scale
) {}

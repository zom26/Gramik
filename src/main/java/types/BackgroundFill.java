package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BackgroundFill (
    @JsonProperty("type")
    String type,

    @JsonProperty("color")
    Long color
) {}

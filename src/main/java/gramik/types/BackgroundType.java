package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BackgroundType (
    @JsonProperty("type")
    String type,

    @JsonProperty("fill")
    BackgroundFill fill,

    @JsonProperty("dark_theme_dimming")
    Long darkThemeDimming
) {}

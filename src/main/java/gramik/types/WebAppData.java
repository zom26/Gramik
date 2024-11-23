package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WebAppData (
    @JsonProperty("data")
    String data,

    @JsonProperty("button_text")
    String buttonText
) {}

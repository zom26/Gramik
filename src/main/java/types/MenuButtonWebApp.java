package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MenuButtonWebApp (
    @JsonProperty("type")
    String type,

    @JsonProperty("text")
    String text,

    @JsonProperty("web_app")
    WebAppInfo webApp
) {}

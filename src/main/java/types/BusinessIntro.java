package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BusinessIntro (
    @JsonProperty("title")
    String title,

    @JsonProperty("message")
    String message,

    @JsonProperty("sticker")
    Sticker sticker
) {}

package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Game (
    @JsonProperty("title")
    String title,

    @JsonProperty("description")
    String description,

    @JsonProperty("photo")
    PhotoSize[] photo,

    @JsonProperty("text")
    String text,

    @JsonProperty("text_entities")
    MessageEntity[] textEntities,

    @JsonProperty("animation")
    Animation animation
) {}

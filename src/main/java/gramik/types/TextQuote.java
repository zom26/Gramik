package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TextQuote (
    @JsonProperty("text")
    String text,

    @JsonProperty("entities")
    MessageEntity[] entities,

    @JsonProperty("position")
    Long position,

    @JsonProperty("is_manual")
    Boolean isManual
) {}

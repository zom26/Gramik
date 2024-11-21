package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PassportElementErrorUnspecified (
    @JsonProperty("source")
    String source,

    @JsonProperty("type")
    String type,

    @JsonProperty("element_hash")
    String elementHash,

    @JsonProperty("message")
    String message
) {}

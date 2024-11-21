package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PassportElementErrorTranslationFile (
    @JsonProperty("source")
    String source,

    @JsonProperty("type")
    String type,

    @JsonProperty("file_hash")
    String fileHash,

    @JsonProperty("message")
    String message
) {}

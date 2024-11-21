package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PassportElementErrorTranslationFiles (
    @JsonProperty("source")
    String source,

    @JsonProperty("type")
    String type,

    @JsonProperty("file_hashes")
    String[] fileHashes,

    @JsonProperty("message")
    String message
) {}

package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PhotoSize (
    @JsonProperty("file_id")
    String fileId,

    @JsonProperty("file_unique_id")
    String fileUniqueId,

    @JsonProperty("width")
    Long width,

    @JsonProperty("height")
    Long height,

    @JsonProperty("file_size")
    Long fileSize
) {}

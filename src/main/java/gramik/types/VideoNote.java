package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VideoNote (
    @JsonProperty("file_id")
    String fileId,

    @JsonProperty("file_unique_id")
    String fileUniqueId,

    @JsonProperty("length")
    Long length,

    @JsonProperty("duration")
    Long duration,

    @JsonProperty("thumbnail")
    PhotoSize thumbnail,

    @JsonProperty("file_size")
    Long fileSize
) {}

package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Audio (
    @JsonProperty("file_id")
    String fileId,

    @JsonProperty("file_unique_id")
    String fileUniqueId,

    @JsonProperty("duration")
    Long duration,

    @JsonProperty("performer")
    String performer,

    @JsonProperty("title")
    String title,

    @JsonProperty("file_name")
    String fileName,

    @JsonProperty("mime_type")
    String mimeType,

    @JsonProperty("file_size")
    Long fileSize,

    @JsonProperty("thumbnail")
    PhotoSize thumbnail
) {}

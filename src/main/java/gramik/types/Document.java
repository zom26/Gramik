package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Document (
    @JsonProperty("file_id")
    String fileId,

    @JsonProperty("file_unique_id")
    String fileUniqueId,

    @JsonProperty("thumbnail")
    PhotoSize thumbnail,

    @JsonProperty("file_name")
    String fileName,

    @JsonProperty("mime_type")
    String mimeType,

    @JsonProperty("file_size")
    Long fileSize
) {}

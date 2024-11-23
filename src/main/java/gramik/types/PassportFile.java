package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PassportFile (
    @JsonProperty("file_id")
    String fileId,

    @JsonProperty("file_unique_id")
    String fileUniqueId,

    @JsonProperty("file_size")
    Long fileSize,

    @JsonProperty("file_date")
    Long fileDate
) {}

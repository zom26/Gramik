package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ChatPhoto (
    @JsonProperty("small_file_id")
    String smallFileId,

    @JsonProperty("small_file_unique_id")
    String smallFileUniqueId,

    @JsonProperty("big_file_id")
    String bigFileId,

    @JsonProperty("big_file_unique_id")
    String bigFileUniqueId
) {}

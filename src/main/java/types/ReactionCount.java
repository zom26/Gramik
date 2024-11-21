package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ReactionCount (
    @JsonProperty("type")
    ReactionType type,

    @JsonProperty("total_count")
    Long totalCount
) {}

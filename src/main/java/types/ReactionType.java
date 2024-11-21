package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ReactionType (
    @JsonProperty("type")
    String type,

    @JsonProperty("emoji")
    String emoji
) {}

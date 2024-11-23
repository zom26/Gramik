package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ChatBoostUpdated (
    @JsonProperty("chat")
    Chat chat,

    @JsonProperty("boost")
    ChatBoost boost
) {}

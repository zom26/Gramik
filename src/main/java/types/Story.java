package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Story (
    @JsonProperty("chat")
    Chat chat,

    @JsonProperty("id")
    Long id
) {}

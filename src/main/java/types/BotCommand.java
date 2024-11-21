package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BotCommand (
    @JsonProperty("command")
    String command,

    @JsonProperty("description")
    String description
) {}

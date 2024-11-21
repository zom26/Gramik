package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LoginUrl (
    @JsonProperty("url")
    String url,

    @JsonProperty("forward_text")
    String forwardText,

    @JsonProperty("bot_username")
    String botUsername,

    @JsonProperty("request_write_access")
    Boolean requestWriteAccess
) {}

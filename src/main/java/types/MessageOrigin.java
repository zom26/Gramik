package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MessageOrigin (
    @JsonProperty("type")
    String type,

    @JsonProperty("date")
    Long date,

    @JsonProperty("sender_user")
    User senderUser
) {}

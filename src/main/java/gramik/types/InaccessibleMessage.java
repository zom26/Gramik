package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InaccessibleMessage (
    @JsonProperty("chat")
    Chat chat,

    @JsonProperty("message_id")
    Long messageId,

    @JsonProperty("date")
    Long date
) {}

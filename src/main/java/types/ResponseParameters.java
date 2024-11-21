package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResponseParameters (
    @JsonProperty("migrate_to_chat_id")
    Long migrateToChatId,

    @JsonProperty("retry_after")
    Long retryAfter
) {}

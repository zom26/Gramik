package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BusinessMessagesDeleted (
    @JsonProperty("business_connection_id")
    String businessConnectionId,

    @JsonProperty("chat")
    Chat chat,

    @JsonProperty("message_ids")
    Integer[] messageIds
) {}

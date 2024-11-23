package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BusinessConnection (
    @JsonProperty("id")
    String id,

    @JsonProperty("user")
    User user,

    @JsonProperty("user_chat_id")
    Long userChatId,

    @JsonProperty("date")
    Long date,

    @JsonProperty("can_reply")
    Boolean canReply,

    @JsonProperty("is_enabled")
    Boolean isEnabled
) {}

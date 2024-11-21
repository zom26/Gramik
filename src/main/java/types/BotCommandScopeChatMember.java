package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BotCommandScopeChatMember (
    @JsonProperty("type")
    String type,

    @JsonProperty("chat_id")
    Long chatId,

    @JsonProperty("user_id")
    Long userId
) {}

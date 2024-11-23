package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BotCommandScopeChat (
    @JsonProperty("type")
    String type,

    @JsonProperty("chat_id")
    Long chatId
) {}

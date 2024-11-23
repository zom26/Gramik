package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SwitchInlineQueryChosenChat (
    @JsonProperty("query")
    String query,

    @JsonProperty("allow_user_chats")
    Boolean allowUserChats,

    @JsonProperty("allow_bot_chats")
    Boolean allowBotChats,

    @JsonProperty("allow_group_chats")
    Boolean allowGroupChats,

    @JsonProperty("allow_channel_chats")
    Boolean allowChannelChats
) {}

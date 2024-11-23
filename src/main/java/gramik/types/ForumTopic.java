package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ForumTopic (
    @JsonProperty("message_thread_id")
    Long messageThreadId,

    @JsonProperty("name")
    String name,

    @JsonProperty("icon_color")
    Long iconColor,

    @JsonProperty("icon_custom_emoji_id")
    String iconCustomEmojiId
) {}

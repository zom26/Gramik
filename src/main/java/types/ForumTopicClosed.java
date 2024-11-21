package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ForumTopicClosed (
    @JsonProperty("name")
    String name,

    @JsonProperty("icon_custom_emoji_id")
    String iconCustomEmojiId
) {}

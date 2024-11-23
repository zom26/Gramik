package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ForumTopicCreated (
    @JsonProperty("name")
    String name,

    @JsonProperty("icon_color")
    Long iconColor,

    @JsonProperty("icon_custom_emoji_id")
    String iconCustomEmojiId
) {}

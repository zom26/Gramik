package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MaybeInaccessibleMessage (
    @JsonProperty("type")
    String type,

    @JsonProperty("offset")
    Long offset,

    @JsonProperty("length")
    Long length,

    @JsonProperty("url")
    String url,

    @JsonProperty("user")
    User user,

    @JsonProperty("language")
    String language,

    @JsonProperty("custom_emoji_id")
    String customEmojiId
) {}

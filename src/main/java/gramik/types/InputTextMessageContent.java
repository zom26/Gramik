package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InputTextMessageContent (
    @JsonProperty("message_text")
    String messageText,

    @JsonProperty("parse_mode")
    String parseMode,

    @JsonProperty("entities")
    MessageEntity[] entities,

    @JsonProperty("link_preview_options")
    LinkPreviewOptions linkPreviewOptions
) {}

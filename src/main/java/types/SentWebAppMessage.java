package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SentWebAppMessage (
    @JsonProperty("inline_message_id")
    String inlineMessageId
) {}

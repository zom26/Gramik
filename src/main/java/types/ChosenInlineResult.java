package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ChosenInlineResult (
    @JsonProperty("result_id")
    String resultId,

    @JsonProperty("from")
    User from,

    @JsonProperty("location")
    Location location,

    @JsonProperty("inline_message_id")
    String inlineMessageId,

    @JsonProperty("query")
    String query
) {}

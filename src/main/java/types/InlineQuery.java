package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InlineQuery (
    @JsonProperty("id")
    String id,

    @JsonProperty("from")
    User from,

    @JsonProperty("query")
    String query,

    @JsonProperty("offset")
    String offset,

    @JsonProperty("chat_type")
    String chatType,

    @JsonProperty("location")
    Location location
) {}

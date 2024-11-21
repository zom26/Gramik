package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ChatBoostRemoved (
    @JsonProperty("chat")
    Chat chat,

    @JsonProperty("boost_id")
    String boostId,

    @JsonProperty("remove_date")
    Long removeDate,

    @JsonProperty("source")
    ChatBoostSource source
) {}

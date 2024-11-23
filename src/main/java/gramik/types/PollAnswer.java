package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PollAnswer (
    @JsonProperty("poll_id")
    String pollId,

    @JsonProperty("voter_chat")
    Chat voterChat,

    @JsonProperty("user")
    User user,

    @JsonProperty("option_ids")
    Integer[] optionIds
) {}

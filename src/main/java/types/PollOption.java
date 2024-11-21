package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PollOption (
    @JsonProperty("text")
    String text,

    @JsonProperty("text_entities")
    MessageEntity[] textEntities,

    @JsonProperty("voter_count")
    Long voterCount
) {}

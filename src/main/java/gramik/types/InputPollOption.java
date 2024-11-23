package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InputPollOption (
    @JsonProperty("text")
    String text,

    @JsonProperty("text_parse_mode")
    String textParseMode,

    @JsonProperty("text_entities")
    MessageEntity[] textEntities
) {}

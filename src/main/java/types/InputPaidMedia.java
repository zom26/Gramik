package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InputPaidMedia (
    @JsonProperty("type")
    String type,

    @JsonProperty("media")
    String media
) {}

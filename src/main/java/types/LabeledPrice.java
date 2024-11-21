package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LabeledPrice (
    @JsonProperty("label")
    String label,

    @JsonProperty("amount")
    Long amount
) {}

package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ShippingOption (
    @JsonProperty("id")
    String id,

    @JsonProperty("title")
    String title,

    @JsonProperty("prices")
    LabeledPrice[] prices
) {}

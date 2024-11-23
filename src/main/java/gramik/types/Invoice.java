package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Invoice (
    @JsonProperty("title")
    String title,

    @JsonProperty("description")
    String description,

    @JsonProperty("start_parameter")
    String startParameter,

    @JsonProperty("currency")
    String currency,

    @JsonProperty("total_amount")
    Long totalAmount
) {}

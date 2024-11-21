package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BusinessOpeningHoursInterval (
    @JsonProperty("opening_minute")
    Long openingMinute,

    @JsonProperty("closing_minute")
    Long closingMinute
) {}

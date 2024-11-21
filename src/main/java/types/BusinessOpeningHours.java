package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BusinessOpeningHours (
    @JsonProperty("time_zone_name")
    String timeZoneName,

    @JsonProperty("opening_hours")
    BusinessOpeningHoursInterval[] openingHours
) {}

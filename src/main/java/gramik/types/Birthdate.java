package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Birthdate (
    @JsonProperty("day")
    Long day,

    @JsonProperty("month")
    Long month,

    @JsonProperty("year")
    Long year
) {}

package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ChatLocation (
    @JsonProperty("location")
    Location location,

    @JsonProperty("address")
    String address
) {}

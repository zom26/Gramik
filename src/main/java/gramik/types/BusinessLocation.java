package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BusinessLocation (
    @JsonProperty("address")
    String address,

    @JsonProperty("location")
    Location location
) {}

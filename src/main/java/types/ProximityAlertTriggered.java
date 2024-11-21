package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ProximityAlertTriggered (
    @JsonProperty("traveler")
    User traveler,

    @JsonProperty("watcher")
    User watcher,

    @JsonProperty("distance")
    Long distance
) {}

package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MessageAutoDeleteTimerChanged (
    @JsonProperty("message_auto_delete_time")
    Long messageAutoDeleteTime
) {}

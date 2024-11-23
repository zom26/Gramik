package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ChatMemberLeft (
    @JsonProperty("status")
    String status,

    @JsonProperty("user")
    User user
) {}

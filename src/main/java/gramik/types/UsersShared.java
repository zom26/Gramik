package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UsersShared (
    @JsonProperty("request_id")
    Long requestId,

    @JsonProperty("users")
    SharedUser[] users
) {}

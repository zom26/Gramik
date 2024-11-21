package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GeneralForumTopicUnhidden (
    @JsonProperty("user_id")
    Long userId,

    @JsonProperty("first_name")
    String firstName,

    @JsonProperty("last_name")
    String lastName,

    @JsonProperty("username")
    String username,

    @JsonProperty("photo")
    PhotoSize[] photo
) {}

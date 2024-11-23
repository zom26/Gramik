package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Chat (
    @JsonProperty("id")
    Long id,

    @JsonProperty("type")
    String type,

    @JsonProperty("title")
    String title,

    @JsonProperty("username")
    String username,

    @JsonProperty("first_name")
    String firstName,

    @JsonProperty("last_name")
    String lastName,

    @JsonProperty("is_forum")
    Boolean isForum
) {}

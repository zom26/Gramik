package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ChatMember (
    @JsonProperty("status")
    String status,

    @JsonProperty("user")
    User user,

    @JsonProperty("is_anonymous")
    Boolean isAnonymous,

    @JsonProperty("custom_title")
    String customTitle
) {}

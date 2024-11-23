package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PreparedInlineMessage (
    @JsonProperty("id")
    String id,

    @JsonProperty("expiration_date")
    Long expirationDate
) {}

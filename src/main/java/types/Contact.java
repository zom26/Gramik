package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Contact (
    @JsonProperty("phone_number")
    String phoneNumber,

    @JsonProperty("first_name")
    String firstName,

    @JsonProperty("last_name")
    String lastName,

    @JsonProperty("user_id")
    Long userId,

    @JsonProperty("vcard")
    String vcard
) {}

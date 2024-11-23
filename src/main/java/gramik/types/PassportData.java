package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PassportData (
    @JsonProperty("data")
    EncryptedPassportElement[] data,

    @JsonProperty("credentials")
    EncryptedCredentials credentials
) {}

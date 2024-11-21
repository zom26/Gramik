package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record EncryptedCredentials (
    @JsonProperty("data")
    String data,

    @JsonProperty("hash")
    String hash,

    @JsonProperty("secret")
    String secret
) {}

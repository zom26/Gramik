package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record EncryptedPassportElement (
    @JsonProperty("type")
    String type,

    @JsonProperty("data")
    String data,

    @JsonProperty("phone_number")
    String phoneNumber,

    @JsonProperty("email")
    String email,

    @JsonProperty("files")
    PassportFile[] files,

    @JsonProperty("front_side")
    PassportFile frontSide,

    @JsonProperty("reverse_side")
    PassportFile reverseSide,

    @JsonProperty("selfie")
    PassportFile selfie,

    @JsonProperty("translation")
    PassportFile[] translation,

    @JsonProperty("hash")
    String hash
) {}

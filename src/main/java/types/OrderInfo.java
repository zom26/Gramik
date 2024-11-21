package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OrderInfo (
    @JsonProperty("name")
    String name,

    @JsonProperty("phone_number")
    String phoneNumber,

    @JsonProperty("email")
    String email,

    @JsonProperty("shipping_address")
    ShippingAddress shippingAddress
) {}

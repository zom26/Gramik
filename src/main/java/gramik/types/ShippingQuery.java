package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ShippingQuery (
    @JsonProperty("id")
    String id,

    @JsonProperty("from")
    User from,

    @JsonProperty("invoice_payload")
    String invoicePayload,

    @JsonProperty("shipping_address")
    ShippingAddress shippingAddress
) {}

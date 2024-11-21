package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PreCheckoutQuery (
    @JsonProperty("id")
    String id,

    @JsonProperty("from")
    User from,

    @JsonProperty("currency")
    String currency,

    @JsonProperty("total_amount")
    Long totalAmount,

    @JsonProperty("invoice_payload")
    String invoicePayload,

    @JsonProperty("shipping_option_id")
    String shippingOptionId,

    @JsonProperty("order_info")
    OrderInfo orderInfo
) {}

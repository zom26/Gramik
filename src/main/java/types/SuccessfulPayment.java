package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SuccessfulPayment (
    @JsonProperty("currency")
    String currency,

    @JsonProperty("total_amount")
    Long totalAmount,

    @JsonProperty("invoice_payload")
    String invoicePayload,

    @JsonProperty("subscription_expiration_date")
    Long subscriptionExpirationDate,

    @JsonProperty("is_recurring")
    Boolean isRecurring,

    @JsonProperty("is_first_recurring")
    Boolean isFirstRecurring,

    @JsonProperty("shipping_option_id")
    String shippingOptionId,

    @JsonProperty("order_info")
    OrderInfo orderInfo,

    @JsonProperty("telegram_payment_charge_id")
    String telegramPaymentChargeId,

    @JsonProperty("provider_payment_charge_id")
    String providerPaymentChargeId
) {}

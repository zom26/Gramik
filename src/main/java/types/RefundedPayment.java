package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RefundedPayment (
    @JsonProperty("currency")
    String currency,

    @JsonProperty("total_amount")
    Long totalAmount,

    @JsonProperty("invoice_payload")
    String invoicePayload,

    @JsonProperty("telegram_payment_charge_id")
    String telegramPaymentChargeId,

    @JsonProperty("provider_payment_charge_id")
    String providerPaymentChargeId
) {}

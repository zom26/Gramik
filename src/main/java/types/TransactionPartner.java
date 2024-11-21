package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TransactionPartner (
    @JsonProperty("type")
    String type,

    @JsonProperty("user")
    User user,

    @JsonProperty("invoice_payload")
    String invoicePayload,

    @JsonProperty("subscription_period")
    Long subscriptionPeriod,

    @JsonProperty("paid_media")
    PaidMedia[] paidMedia,

    @JsonProperty("paid_media_payload")
    String paidMediaPayload,

    @JsonProperty("gift")
    String gift
) {}

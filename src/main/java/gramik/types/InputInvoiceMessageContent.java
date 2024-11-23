package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InputInvoiceMessageContent (
    @JsonProperty("title")
    String title,

    @JsonProperty("description")
    String description,

    @JsonProperty("payload")
    String payload,

    @JsonProperty("provider_token")
    String providerToken,

    @JsonProperty("currency")
    String currency,

    @JsonProperty("prices")
    LabeledPrice[] prices,

    @JsonProperty("max_tip_amount")
    Long maxTipAmount,

    @JsonProperty("suggested_tip_amounts")
    Integer[] suggestedTipAmounts,

    @JsonProperty("provider_data")
    String providerData,

    @JsonProperty("photo_url")
    String photoUrl,

    @JsonProperty("photo_size")
    Long photoSize,

    @JsonProperty("photo_width")
    Long photoWidth,

    @JsonProperty("photo_height")
    Long photoHeight,

    @JsonProperty("need_name")
    Boolean needName,

    @JsonProperty("need_phone_number")
    Boolean needPhoneNumber,

    @JsonProperty("need_email")
    Boolean needEmail,

    @JsonProperty("need_shipping_address")
    Boolean needShippingAddress,

    @JsonProperty("send_phone_number_to_provider")
    Boolean sendPhoneNumberToProvider,

    @JsonProperty("send_email_to_provider")
    Boolean sendEmailToProvider,

    @JsonProperty("is_flexible")
    Boolean isFlexible
) {}

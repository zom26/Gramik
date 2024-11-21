package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TransactionPartnerFragment (
    @JsonProperty("type")
    String type,

    @JsonProperty("withdrawal_state")
    RevenueWithdrawalState withdrawalState
) {}

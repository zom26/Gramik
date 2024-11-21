package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TransactionPartnerTelegramApi (
    @JsonProperty("type")
    String type,

    @JsonProperty("request_count")
    Long requestCount
) {}

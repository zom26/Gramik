package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record StarTransaction (
    @JsonProperty("id")
    String id,

    @JsonProperty("amount")
    Long amount,

    @JsonProperty("date")
    Long date,

    @JsonProperty("source")
    TransactionPartner source,

    @JsonProperty("receiver")
    TransactionPartner receiver
) {}

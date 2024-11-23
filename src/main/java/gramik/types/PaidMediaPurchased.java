package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PaidMediaPurchased (
    @JsonProperty("from")
    User from,

    @JsonProperty("paid_media_payload")
    String paidMediaPayload
) {}

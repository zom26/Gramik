package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ChatInviteLink (
    @JsonProperty("invite_link")
    String inviteLink,

    @JsonProperty("creator")
    User creator,

    @JsonProperty("creates_join_request")
    Boolean createsJoinRequest,

    @JsonProperty("is_primary")
    Boolean isPrimary,

    @JsonProperty("is_revoked")
    Boolean isRevoked,

    @JsonProperty("name")
    String name,

    @JsonProperty("expire_date")
    Long expireDate,

    @JsonProperty("member_limit")
    Long memberLimit,

    @JsonProperty("pending_join_request_count")
    Long pendingJoinRequestCount,

    @JsonProperty("subscription_period")
    Long subscriptionPeriod,

    @JsonProperty("subscription_price")
    Long subscriptionPrice
) {}

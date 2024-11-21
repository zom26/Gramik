package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WebhookInfo (
    @JsonProperty("url")
    String url,

    @JsonProperty("has_custom_certificate")
    Boolean hasCustomCertificate,

    @JsonProperty("pending_update_count")
    Long pendingUpdateCount,

    @JsonProperty("ip_address")
    String ipAddress,

    @JsonProperty("last_error_date")
    Long lastErrorDate,

    @JsonProperty("last_error_message")
    String lastErrorMessage,

    @JsonProperty("last_synchronization_error_date")
    Long lastSynchronizationErrorDate,

    @JsonProperty("max_connections")
    Long maxConnections,

    @JsonProperty("allowed_updates")
    String[] allowedUpdates
) {}

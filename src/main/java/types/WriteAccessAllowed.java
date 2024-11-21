package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WriteAccessAllowed (
    @JsonProperty("from_request")
    Boolean fromRequest,

    @JsonProperty("web_app_name")
    String webAppName,

    @JsonProperty("from_attachment_menu")
    Boolean fromAttachmentMenu
) {}

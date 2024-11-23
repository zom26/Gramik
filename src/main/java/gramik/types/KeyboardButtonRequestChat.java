package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record KeyboardButtonRequestChat (
    @JsonProperty("request_id")
    Long requestId,

    @JsonProperty("chat_is_channel")
    Boolean chatIsChannel,

    @JsonProperty("chat_is_forum")
    Boolean chatIsForum,

    @JsonProperty("chat_has_username")
    Boolean chatHasUsername,

    @JsonProperty("chat_is_created")
    Boolean chatIsCreated,

    @JsonProperty("user_administrator_rights")
    ChatAdministratorRights userAdministratorRights,

    @JsonProperty("bot_administrator_rights")
    ChatAdministratorRights botAdministratorRights,

    @JsonProperty("bot_is_member")
    Boolean botIsMember,

    @JsonProperty("request_title")
    Boolean requestTitle,

    @JsonProperty("request_username")
    Boolean requestUsername,

    @JsonProperty("request_photo")
    Boolean requestPhoto
) {}

package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record KeyboardButton (
    @JsonProperty("text")
    String text,

    @JsonProperty("request_users")
    KeyboardButtonRequestUsers requestUsers,

    @JsonProperty("request_chat")
    KeyboardButtonRequestChat requestChat,

    @JsonProperty("request_contact")
    Boolean requestContact,

    @JsonProperty("request_location")
    Boolean requestLocation,

    @JsonProperty("request_poll")
    KeyboardButtonPollType requestPoll,

    @JsonProperty("web_app")
    WebAppInfo webApp
) {
    public KeyboardButton(String text) {
        this(text, null, null, null, null, null, null);
    }
}

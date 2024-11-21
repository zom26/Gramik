package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InlineKeyboardButton (
    @JsonProperty("text")
    String text,

    @JsonProperty("url")
    String url,

    @JsonProperty("callback_data")
    String callbackData,

    @JsonProperty("web_app")
    WebAppInfo webApp,

    @JsonProperty("login_url")
    LoginUrl loginUrl,

    @JsonProperty("switch_inline_query")
    String switchInlineQuery,

    @JsonProperty("switch_inline_query_current_chat")
    String switchInlineQueryCurrentChat,

    @JsonProperty("switch_inline_query_chosen_chat")
    SwitchInlineQueryChosenChat switchInlineQueryChosenChat,

    @JsonProperty("copy_text")
    CopyTextButton copyText,

    @JsonProperty("pay")
    Boolean pay
) {}

package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InlineQueryResultsButton (
    @JsonProperty("text")
    String text,

    @JsonProperty("web_app")
    WebAppInfo webApp,

    @JsonProperty("start_parameter")
    String startParameter
) {}

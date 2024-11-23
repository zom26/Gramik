package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ChatShared (
    @JsonProperty("request_id")
    Long requestId,

    @JsonProperty("chat_id")
    Long chatId,

    @JsonProperty("title")
    String title,

    @JsonProperty("username")
    String username,

    @JsonProperty("photo")
    PhotoSize[] photo
) {}

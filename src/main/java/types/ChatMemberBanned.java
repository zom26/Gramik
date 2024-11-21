package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ChatMemberBanned (
    @JsonProperty("status")
    String status,

    @JsonProperty("user")
    User user,

    @JsonProperty("until_date")
    Long untilDate
) {}

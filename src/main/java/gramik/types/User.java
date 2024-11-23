package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record User (
    @JsonProperty("id")
    Long id,

    @JsonProperty("is_bot")
    Boolean isBot,

    @JsonProperty("first_name")
    String firstName,

    @JsonProperty("last_name")
    String lastName,

    @JsonProperty("username")
    String username,

    @JsonProperty("language_code")
    String languageCode,

    @JsonProperty("is_premium")
    Boolean isPremium,

    @JsonProperty("added_to_attachment_menu")
    Boolean addedToAttachmentMenu,

    @JsonProperty("can_join_groups")
    Boolean canJoinGroups,

    @JsonProperty("can_read_all_group_messages")
    Boolean canReadAllGroupMessages,

    @JsonProperty("supports_inline_queries")
    Boolean supportsInlineQueries,

    @JsonProperty("can_connect_to_business")
    Boolean canConnectToBusiness,

    @JsonProperty("has_main_web_app")
    Boolean hasMainWebApp
) {}

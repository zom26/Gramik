package types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ExternalReplyInfo (
    @JsonProperty("origin")
    MessageOrigin origin,

    @JsonProperty("chat")
    Chat chat,

    @JsonProperty("message_id")
    Long messageId,

    @JsonProperty("link_preview_options")
    LinkPreviewOptions linkPreviewOptions,

    @JsonProperty("animation")
    Animation animation,

    @JsonProperty("audio")
    Audio audio,

    @JsonProperty("document")
    Document document,

    @JsonProperty("paid_media")
    PaidMediaInfo paidMedia,

    @JsonProperty("photo")
    PhotoSize[] photo,

    @JsonProperty("sticker")
    Sticker sticker,

    @JsonProperty("story")
    Story story,

    @JsonProperty("video")
    Video video,

    @JsonProperty("video_note")
    VideoNote videoNote,

    @JsonProperty("voice")
    Voice voice,

    @JsonProperty("has_media_spoiler")
    Boolean hasMediaSpoiler,

    @JsonProperty("contact")
    Contact contact,

    @JsonProperty("dice")
    Dice dice,

    @JsonProperty("game")
    Game game,

    @JsonProperty("giveaway")
    Giveaway giveaway,

    @JsonProperty("giveaway_winners")
    GiveawayWinners giveawayWinners,

    @JsonProperty("invoice")
    Invoice invoice,

    @JsonProperty("location")
    Location location,

    @JsonProperty("poll")
    Poll poll,

    @JsonProperty("venue")
    Venue venue
) {}

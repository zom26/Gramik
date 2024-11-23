package gramik.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record StickerSet (
    @JsonProperty("name")
    String name,

    @JsonProperty("title")
    String title,

    @JsonProperty("sticker_type")
    String stickerType,

    @JsonProperty("stickers")
    Sticker[] stickers,

    @JsonProperty("thumbnail")
    PhotoSize thumbnail
) {}

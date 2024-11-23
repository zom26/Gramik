package gramik.parameters;

public enum ParseMode {
    HTML, MARKDOWN, MARKDOWNV2;


    @Override
    public String toString() {
        return switch (this) {
            case HTML -> "HTML";
            case MARKDOWN -> "Markdown";
            case MARKDOWNV2 -> "MarkdownV2";
        };
    }
}

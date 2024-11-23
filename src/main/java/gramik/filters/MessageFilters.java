package gramik.filters;

import gramik.types.Message;

import java.util.function.Predicate;

public class MessageFilters {
    public static final Predicate<Message> ALWAYS = x -> true;
    public static final Predicate<Message> NEVER = x -> false;
    public static final Predicate<Message> TEXT_MESSAGE = x -> x.text() != null;

    public static Predicate<Message> COMMAND(String command) {
        return TEXT_MESSAGE.and(x -> x.text().startsWith(command));
    }
    public static Predicate<Message> CHAT_ID(Long chatId) {
        return x -> x.chat().id().equals(chatId);
    }
    public static Predicate<Message> USER_ID(Long userId) {
        return x -> x.from() != null && x.from().id().equals(userId);
    }


}

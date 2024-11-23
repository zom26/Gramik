package gramik;

import gramik.types.*;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterContainer {
    private final FilterArray<Message> messagesFilters = new FilterArray<>(),
            businessMessagesFilters = new FilterArray<>();
    private final FilterArray<Update> updatesFilters = new FilterArray<>();

    void registerMessageFilter(Predicate<Message> filter, Consumer<Message> consumer) {
        messagesFilters.add(filter, consumer);
    }

    void registerUpdateFilter(Predicate<Update> filter, Consumer<Update> consumer) {
        updatesFilters.add(filter, consumer);
    }

    void registerBusinessMessageFilter(Predicate<Message> filter, Consumer<Message> consumer) {
        businessMessagesFilters.add(filter, consumer);
    }

    boolean consume(Update update) {
        return consume(update, false);
    }

    boolean consumeAndRemove(Update update) {
        return consume(update, true);
    }

    private boolean consume(Update update, boolean remove) {
        return update.message() != null && messagesFilters.consume(update.message(), remove) ||
                update.businessMessage() != null && messagesFilters.consume(update.businessMessage(), remove) ||
                updatesFilters.consume(update, remove);
    }


}

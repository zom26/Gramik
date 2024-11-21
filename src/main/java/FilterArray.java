import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterArray<T> {
    private final Map<Predicate<T>, Consumer<T>> filterMap = new LinkedHashMap<>();

    FilterArray() {
    }

    synchronized void add(Predicate<T> predicate, Consumer<T> consumer) {
        filterMap.put(predicate, consumer);
    }

    synchronized void remove(Predicate<T> predicate) {
        filterMap.remove(predicate);
    }

    boolean consume(T t) {
        return consume(t, false);
    }

    boolean consumeAndRemove(T t) {
        return consume(t, true);
    }

    boolean consume(T t, boolean remove) {
        for (Map.Entry<Predicate<T>, Consumer<T>> entry : filterMap.entrySet()) {
            if (entry.getKey().test(t)) {
                entry.getValue().accept(t);
                if (remove) {
                    remove(entry.getKey());
                }
                return true;
            }
        }
        return false;
    }

}

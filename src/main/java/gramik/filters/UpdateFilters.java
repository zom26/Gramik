package gramik.filters;

import java.util.function.Predicate;

import gramik.types.*;

public class UpdateFilters {
    public static final Predicate<Update> ALWAYS = x -> true;
    public static final Predicate<Update> NEVER = x -> false;
    public static final Predicate<Update> MESSAGE = x -> x.message() != null;
    public static final Predicate<Update> BUSINESS_MESSAGE = x -> x.businessMessage() != null;
    public static final Predicate<Update> TEXT_MESSAGE = MESSAGE.and(x -> x.message().text() != null);

    public static Predicate<Update> COMMAND(String command) {
        return TEXT_MESSAGE.and(x -> x.message().text().startsWith(command));
    }

}

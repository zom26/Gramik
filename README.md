# Gramik

It is something like a lib for Telegram bots on java.

# Examples

### Echo bot

Bot returning your text messages:

``` java
gramik.GramikBot bot = new gramik.GramikBot("BotToken");
bot.registerFilter(UpdateFilters.COMMAND("/start"), (update) -> {
    bot.sendMessage(update.message().chat().id(), "Ohae its echo bot. :/");
});
bot.registerFilter(UpdateFilters.TEXT_MESSAGE, (update) -> {
    bot.sendMessage(update.message().chat().id(), update.message().text());
});
bot.infinityPolling();  
```

---

### Another example

This bot is counting your messages up to two :)

``` java
gramik.GramikBot bot = new gramik.GramikBot("BotToken");
bot.registerMessageFilter(MessageFilters.TEXT_MESSAGE.and(MessageFilters.COMMAND("/count")), message -> {
    bot.sendMessage(message.chat().id(), "Counting is started now. 1!");
    bot.registerMessageOneTimeFilter(MessageFilters.ALWAYS,
            (x) -> bot.sendMessage(message.chat().id(), "2!! Counting is ended."));
});
```

Yes, he is damn, anyway I love him.

---

### Simple ReplyMarkupKeyboard bot

This bot shows how you can use ReplyMarkupKeyboard

``` java
public class Test {

    private static final GramikBot bot = new GramikBot("BotToken");

    private static void start(Message message) {
        bot.sendMessage(message.chat().id(), "Choose how to format your string",
                new ReplyKeyboardMarkup(new KeyboardButton[][]{{new KeyboardButton("CamelCase"),
                        new KeyboardButton("kebab-case"), new KeyboardButton("snake_case")}}));
        bot.registerMessageOneTimeFilter(MessageFilters.ALWAYS, Test::formatSelector);
    }

    private static void formatSelector(Message message) {
        switch (message.text()) {
            case "CamelCase" ->
                    bot.registerMessageOneTimeFilter(MessageFilters.CHAT_ID(message.chat().id()), Test::camelCase);
            case "snake_case" ->
                    bot.registerMessageOneTimeFilter(MessageFilters.CHAT_ID(message.chat().id()), Test::snakeCase);
            case "kebab-case" ->
                    bot.registerMessageOneTimeFilter(MessageFilters.CHAT_ID(message.chat().id()), Test::kebabCase);
            default -> {
                bot.sendMessage(message.chat().id(), "Wrong mode");
                bot.registerMessageOneTimeFilter(MessageFilters.CHAT_ID(message.chat().id()), Test::formatSelector);
                return;
            }
        }
        bot.sendMessage(message.chat().id(), "I need your string now", new ReplyKeyboardMarkup.Remove());
    }

    private static void camelCase(Message message) {
        String[] words = message.text().split("[_\\-\\s]+");
        StringBuilder camelCaseString = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (i == 0) {
                camelCaseString.append(word.toLowerCase());
            } else {
                camelCaseString.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase());
            }
        }
        bot.sendMessage(message.chat().id(), camelCaseString.toString());
    }

    public static void kebabCase(Message message) {
        String[] words = message.text().split("[_\\-\\s]+");
        bot.sendMessage(message.chat().id(),
                String.join("-", Arrays.stream(words).map(String::toLowerCase).toArray(String[]::new)));
    }

    public static void snakeCase(Message message) {
        String[] words = message.text().split("[_\\-\\s]+");
        bot.sendMessage(message.chat().id(), String.join("_",
                Arrays.stream(words).map(String::toLowerCase).toArray(String[]::new)));
    }


    public static void main(String[] args) {
        bot.registerMessageFilter(MessageFilters.COMMAND("/format"), Test::start);
        bot.infinityPolling();
    }
}
```

In this update I added business connection, but not an example, so imagine it because it works similar as common bot
chatting.

---

### ReversedPolishEvaluator

It is simple bot witch can evaluate reversed polish expression got by bot or from business connection

``` java
public class Test {

    private static final GramikBot bot = new GramikBot("BotToken");

    private static void evaluator(Message message) {
        BigInteger res = evaluate(message.text());
        if (res != null) {
            bot.replyMessage(message, res.toString());
        }
    }

    private static boolean isOperation(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("**") || token.equals("%");
    }

    private static BigInteger evaluate(String input) {
        String[] tokens = input.split("\\s+");
        Deque<BigInteger> stack = new LinkedList<>();

        for (String token : tokens) {
            if (isOperation(token)) {
                if (stack.size() < 2) {
                    return null;
                }
                stack.add(switch (token) {
                    case "+" -> stack.pop().add(stack.pop());
                    case "-" -> stack.pop().negate().add(stack.pop());
                    case "*" -> stack.pop().multiply(stack.pop());
                    case "/" -> {
                        BigInteger b = stack.pop(), a = stack.pop();
                        yield a.divide(b);
                    }
                    case "%" -> {
                        BigInteger b = stack.pop(), a = stack.pop();
                        yield a.remainder(b);
                    }
                    case "**" -> {
                        BigInteger b = stack.pop(), a = stack.pop();
                        yield a.pow(b.intValue());
                    }
                    default -> null;
                });

            } else if (token.matches("-?\\d+")) {
                stack.push(new BigInteger(token));
            } else {
                return null;
            }
        }

        if (stack.size() < 2) {
            return stack.getFirst();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        bot.registerAnyMessagesFilter(MessageFilters.ALWAYS, Test::evaluator);
        bot.infinityPolling();
    }
}
```
---
### ForwarderBot

Bot can notify you about getting a message from an important user

``` java
public class Test {

    private static final GramikBot bot = new GramikBot("BotToken");
    private static final Long adminId = AdminId;

    private static void addNewUser(Message message) {
        System.out.println(message.text().substring(1));
        bot.registerBusinessMessageFilter(MessageFilters.USERNAME(message.text().substring(1)), (msg) ->
        {bot.sendMessage(adminId, "New message from important user: @" + msg.from().username() + "\nText:\n" + msg.text());});
    }

    public static void main(String[] args) {
        bot.registerAnyMessagesFilter(MessageFilters.USER_ID(adminId).and(MessageFilters.COMMAND("@")), Test::addNewUser);
        bot.infinityPolling();
    }
}
```
# Types

It is a package of gramik.types used in library to parse gramik.types returned by telegram bot api methods.

Honestly, it was made by python script parsing telegram bot api page. 
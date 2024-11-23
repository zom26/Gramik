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

# Types

It is a package of gramik.types used in library to parse gramik.types returned by telegram bot api methods.

Honestly, it was made by python script parsing telegram bot api page. 
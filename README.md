# Gramik

It is something like a lib for Telegram bots on java.

# Example

Bot returning your text messages:
``` java
GramikBot bot = new GramikBot("BotToken");
bot.registerFilter(UpdateFilters.COMMAND("/start"), (update) -> {
    bot.sendMessage(update.message().chat().id(), "Ohae its echo bot. :/");
});
bot.registerFilter(UpdateFilters.TEXT_MESSAGE, (update) -> {
    bot.sendMessage(update.message().chat().id(), update.message().text());
});
bot.infinityPolling();  
```

# Types

It is a package of types used in library to parse types returned by telegram bot api methods.

Honestly, it was made by python script parsing telegram bot api page. 
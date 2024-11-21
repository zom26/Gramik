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

---

Another example - this bot is counting your messages up to two :)

``` java
GramikBot bot = new GramikBot("BotToken");
bot.registerMessageFilter(MessageFilters.TEXT_MESSAGE.and(MessageFilters.COMMAND("/count")), message -> {
    bot.sendMessage(message.chat().id(), "Counting is started now. 1!");
    bot.registerMessageOneTimeFilter(MessageFilters.ALWAYS,
            (x) -> bot.sendMessage(message.chat().id(), "2!! Counting is ended."));
});
```

Yes, he is damn, anyway I love him. 

# Types

It is a package of types used in library to parse types returned by telegram bot api methods.

Honestly, it was made by python script parsing telegram bot api page. 
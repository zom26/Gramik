# Gramik
Java Telegram Bot Lib or something like that 


Simple example:
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

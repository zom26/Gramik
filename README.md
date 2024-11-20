# Gramik
Java Telegram Bot Lib or something like that 


Simple example:
``` java
GramikBot bot = new GramikBot("BotToken");
bot.registerFilter(UpdatesFilters.commandFilter("/start"), (message) -> {
    bot.sendMessage(message.get("message").get("chat").get("id").asLong(), "Hi! It's echo bot. :/ ");
});
bot.registerFilter(UpdatesFilters.textMessageFilter(), (message) -> {
    bot.sendMessage(message.get("message").get("chat").get("id").asLong(), message.get("message").get("text").asText());
});
bot.infinityPolling();
```

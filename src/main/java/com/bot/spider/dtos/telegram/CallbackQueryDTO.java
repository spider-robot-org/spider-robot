package com.bot.spider.dtos.telegram;

public record CallbackQueryDTO(
        String id,
        FromDTO from,
        MessageDTO message,
        String chat_instance,
        String data
) {
}

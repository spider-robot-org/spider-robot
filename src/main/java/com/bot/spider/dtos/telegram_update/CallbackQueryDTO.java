package com.bot.spider.dtos.telegram_update;

public record CallbackQueryDTO(
        String id,
        FromDTO from,
        MessageDTO message,
        String chat_instance,
        String data
) {
}

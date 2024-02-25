package com.bot.spider.dtos.telegram_update;

public record InlineKeyboardButtonDTO(
        String text,
        String callback_data
) {
}

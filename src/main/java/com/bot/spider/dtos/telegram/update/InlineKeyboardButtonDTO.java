package com.bot.spider.dtos.telegram.update;

public record InlineKeyboardButtonDTO(
        String text,
        String callback_data
) {
}

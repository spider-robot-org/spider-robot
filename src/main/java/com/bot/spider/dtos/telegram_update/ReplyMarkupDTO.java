package com.bot.spider.dtos.telegram_update;


import java.util.List;

public record ReplyMarkupDTO(
        List<List<InlineKeyboardButtonDTO>> inline_keyboard
) {
}

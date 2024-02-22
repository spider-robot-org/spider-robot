package com.bot.spider.dtos.TelegramUpdate;


import java.util.List;

public record ReplyMarkupDTO(
        List<List<InlineKeyboardButtonDTO>> inline_keyboard
) {
}

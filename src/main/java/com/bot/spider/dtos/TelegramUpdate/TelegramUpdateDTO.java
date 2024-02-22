package com.bot.spider.dtos.TelegramUpdate;

import java.util.Optional;

public record TelegramUpdateDTO(
        Optional<CallbackQueryDTO> callback_query,
        Optional<MessageDTO> message
) {
}

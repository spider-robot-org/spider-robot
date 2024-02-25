package com.bot.spider.dtos.telegram_update;

import java.util.Optional;

public record TelegramUpdateDTO(
        Optional<CallbackQueryDTO> callback_query,
        Optional<MessageDTO> message
) {
}

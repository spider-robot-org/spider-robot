package com.bot.spider.dtos.telegram.update;

import java.util.Optional;

public record TelegramUpdateDTO(
        Optional<CallbackQueryDTO> callback_query,
        Optional<MessageDTO> message
) {
}

package com.bot.spider.dtos.telegram;

import java.util.Optional;

public record TelegramUpdateDTO(
        Optional<CallbackQueryDTO> callback_query,
        Optional<MessageDTO> message
) {
}

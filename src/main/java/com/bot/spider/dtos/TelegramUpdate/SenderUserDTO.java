package com.bot.spider.dtos.TelegramUpdate;

public record SenderUserDTO(
        Long id,
        boolean is_bot,
        String first_name,
        String username
) {
}

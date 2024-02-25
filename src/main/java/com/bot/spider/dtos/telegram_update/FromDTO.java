package com.bot.spider.dtos.telegram_update;

public record FromDTO(
        Long id,
        boolean is_bot,
        String first_name,
        String username,
        String language_code
) {
}

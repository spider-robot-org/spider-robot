package com.bot.spider.dtos.telegram_update;

public record ForwardFromDTO(
        Long id,
        boolean is_bot,
        String first_name,
        String username
) {
}

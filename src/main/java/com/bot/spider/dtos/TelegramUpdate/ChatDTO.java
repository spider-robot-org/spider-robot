package com.bot.spider.dtos.TelegramUpdate;

public record ChatDTO(
        Long id,
        String first_name,
        String username,
        String type
) {
}
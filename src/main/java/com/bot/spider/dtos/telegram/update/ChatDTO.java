package com.bot.spider.dtos.telegram.update;

public record ChatDTO(
        Long id,
        String first_name,
        String username,
        String type
) {
}
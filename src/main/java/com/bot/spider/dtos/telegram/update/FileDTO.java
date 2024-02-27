package com.bot.spider.dtos.telegram.update;

public record FileDTO(
        String file_id,
        String file_unique_id,
        long file_size,
        int width,
        int height
) {
}

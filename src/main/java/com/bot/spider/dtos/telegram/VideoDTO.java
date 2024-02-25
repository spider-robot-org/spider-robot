package com.bot.spider.dtos.telegram;

public record VideoDTO(
        int duration,
        int width,
        int height,
        String mime_type,
        FileDTO thumbnail,
        FileDTO thumb,
        String file_id,
        String file_unique_id,
        long file_size
) {
}

package com.bot.spider.dtos.telegram.update;

public record VideoNoteDTO(int duration,
                           int length,
                           FileDTO thumbnail,
                           FileDTO thumb,
                           String file_id,
                           String file_unique_id,
                           long file_size) {
}

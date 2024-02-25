package com.bot.spider.dtos.TelegramUpdate;

import java.util.Optional;

public record MessageDTO(Long message_id,
                         Optional<FromDTO> from,
                         Optional<ChatDTO> chat,
                         long date,
                         String text,
                         Optional<ForwardOriginDTO> forward_origin,
                         Optional<ForwardFromDTO> forward_from,
                         Optional<VideoDTO> video,
                         Optional<VideoNoteDTO> video_note
) {
}

package com.bot.spider.dtos;

import java.util.List;
import java.util.Optional;

public record TelegramMessageDTO(
        Optional<CallbackQueryDTO> callback_query,
        Optional<MessageDTO> message
) {
    public record CallbackQueryDTO(
            String id,
            FromDTO from,
            MessageDTO message,
            String chat_instance,
            String data
    ) {
    }

    public record FromDTO(
            Long id,
            boolean is_bot,
            String first_name,
            String username,
            String language_code
    ) {
    }

    public record MessageDTO(
            Long message_id,
            Optional<FromDTO> from,
            Optional<ChatDTO> chat,
            long date,
            String text,
            Optional<ReplyMarkupDTO> reply_markup
    ) {
    }

    public record ChatDTO(
            Long id,
            String first_name,
            String username,
            String type
    ) {
    }

    public record ReplyMarkupDTO(
            List<List<InlineKeyboardButtonDTO>> inline_keyboard
    ) {
    }

    public record InlineKeyboardButtonDTO(
            String text,
            String callback_data
    ) {
    }
}

package com.bot.spider.dtos;

public record TelegramMessageDTO(
        MessageDTO message
) {
    public record MessageDTO(
            Long message_id,
            FromDTO from,
            ChatDTO chat,
            long date,
            String text
    ) {
    }

    public record FromDTO(
            Long id,
            boolean is_bot,
            String first_name,
            String last_name,
            String username,
            String language_code,
            boolean is_premium,
            boolean added_to_attachment_menu,
            boolean can_join_groups,
            boolean can_read_all_group_messages,
            boolean supports_inline_queries
    ) {
    }

    public record ChatDTO(
            Long id,
            String first_name,
            String username,
            String type
    ) {
    }
}
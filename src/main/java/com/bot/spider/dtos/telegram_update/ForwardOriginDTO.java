package com.bot.spider.dtos.telegram_update;

public record ForwardOriginDTO(
        String type,
        SenderUserDTO sender_user,
        long date
) {
}

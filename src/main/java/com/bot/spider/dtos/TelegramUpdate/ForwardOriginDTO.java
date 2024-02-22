package com.bot.spider.dtos.TelegramUpdate;

public record ForwardOriginDTO(
        String type,
        SenderUserDTO sender_user,
        long date
) {
}

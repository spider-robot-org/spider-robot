package com.bot.spider.dtos.telegram;

public record ForwardOriginDTO(
        String type,
        SenderUserDTO sender_user,
        long date
) {
}

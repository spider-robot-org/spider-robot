package com.bot.spider.dtos.telegram.update;

public record ForwardOriginDTO(
        String type,
        SenderUserDTO sender_user,
        long date
) {
}

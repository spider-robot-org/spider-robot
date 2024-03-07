package com.bot.spider.services.InputProcess;

import com.fasterxml.jackson.annotation.JsonProperty;
public record MessageKeyboard(
        String text,
        @JsonProperty("chat_id")  Long chatId,
        @JsonProperty("message_id") Long messageId,
        @JsonProperty("reply_markup") ReplyMarkup replyMarkup
) {
}

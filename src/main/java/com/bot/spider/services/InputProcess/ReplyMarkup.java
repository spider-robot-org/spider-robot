package com.bot.spider.services.InputProcess;

import com.bot.spider.libs.keyboard.InlineKeyboardButton;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ReplyMarkup(@JsonProperty("inline_keyboard")  List<List<InlineKeyboardButton>> inlineKeyboard) {
}

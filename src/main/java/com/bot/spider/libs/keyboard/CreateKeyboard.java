package com.bot.spider.libs.keyboard;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class CreateKeyboard {
  public static String newKeyboard(Long chatId, String messageText, List<List<InlineKeyboardButton>> inlineKeyboard) {

    KeyboardList keyboardList = new KeyboardList(inlineKeyboard);
    Message message = new Message(chatId,messageText, keyboardList);

    try {
      ObjectMapper objectMapper = new ObjectMapper();
      String jsonString = objectMapper.writeValueAsString(message);

      return jsonString;

    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
}

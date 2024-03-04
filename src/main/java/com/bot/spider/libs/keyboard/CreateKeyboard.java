package com.bot.spider.libs.keyboard;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateKeyboard {
  public static String newKeyboard(Long chatId, String messageText, InlineKeyboard inlineKeyboard) {

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

  public static String newKeyboard(Long chatId, Long messageId, String messageText, InlineKeyboard inlineKeyboard) {
    KeyboardList keyboardList = new KeyboardList(inlineKeyboard);
    ReplyMessage message = new ReplyMessage(chatId, messageId, messageText, keyboardList);

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

package com.bot.spider.libs.keyboard;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class CreateKeyboard {
  public static String newKeyboard(Long chatId, String messageText, KeyboardList createKeyboard) {
    Message message = new Message(chatId,messageText, createKeyboard);

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

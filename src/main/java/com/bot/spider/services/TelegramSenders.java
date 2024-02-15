package com.bot.spider.services;

import com.bot.spider.enums.TelegramChatAction;
import com.bot.spider.libs.telegram.TelegramApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelegramSenders {

  private final HttpClientService httpClientService;
  private TelegramApi telegramApi;

  @Autowired
  public TelegramSenders(HttpClientService httpClientService) {
    this.httpClientService = httpClientService;
    this.telegramApi = new TelegramApi(httpClientService);
  }

  public void sendHello(Long chatId) {
    String jsonBody = String.format("{\"chat_id\":\"%s\",\"text\":\"Olá! Esta é uma resposta do bot.\"}", chatId);
    telegramApi.sendMessage(jsonBody);
  }

  public void sendChatAction(Long chatId, TelegramChatAction action) {
    telegramApi.sendChatAction(chatId, action);
  }

  public void sendVideo(Long chatId, String videoUrl) {
    telegramApi.sendVideo(chatId, videoUrl);
  }

  public void sendKeyboard(String jsonBody) {
    telegramApi.sendMessage(jsonBody);
  }

  public void sendAnyMessage(String text, Long chatId) {
    String jsonBody = String.format("{\"chat_id\":\"%s\",\"text\":\"%s\"}", chatId, text);
    telegramApi.sendMessage(jsonBody);
  }

}

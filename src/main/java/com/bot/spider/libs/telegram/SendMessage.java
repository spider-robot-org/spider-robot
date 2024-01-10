package com.bot.spider.libs.telegram;

import com.bot.spider.interfaces.TelegramApiMethod;
import com.bot.spider.services.HttpClientService;

public class SendMessage implements TelegramApiMethod {
  private int chatId;

  public  SendMessage(int chatId) {
    this.chatId = chatId;
  }
  @Override
  public void execute(HttpClientService httpClientService) {
    String method = "sendMessage";

    // Monta a mensagem JSON (exemplo)
    String jsonBody =  String.format("{\"chat_id\":\"%s\",\"text\":\"Olá! Esta é uma resposta do bot.\"}", this.chatId);

    try {
      httpClientService.sendPostRequest(method, jsonBody);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}

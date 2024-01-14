package com.bot.spider.services;

import com.bot.spider.libs.telegram.TelegramApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendHello {

  private final HttpClientService httpClientService;

  @Autowired
  public  SendHello(HttpClientService httpClientService) {
    this.httpClientService = httpClientService;
  }

  public void execute(Long chatId) {
    TelegramApi telegramApi = new TelegramApi(httpClientService);
    String jsonBody = String.format("{\"chat_id\":\"%s\",\"text\":\"Olá! Esta é uma resposta do bot.\"}", chatId);

    telegramApi.sendMessage(jsonBody);
  }
}

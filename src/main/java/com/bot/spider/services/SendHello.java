package com.bot.spider.services;

import com.bot.spider.libs.telegram.SendMessage;
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
    SendMessage sendMessage = new SendMessage(chatId);
    sendMessage.execute(httpClientService);
  }
}

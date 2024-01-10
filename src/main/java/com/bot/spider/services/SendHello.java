package com.bot.spider.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  com.bot.spider.libs.telegram.SendMessage;

@Service
public class SendHello {

  private HttpClientService  httpClientService;

  @Autowired
  public  SendHello(HttpClientService httpClientService) {
    this.httpClientService = httpClientService;
  }

  public void execute(Long chatId) {
    SendMessage sendMessage = new SendMessage(chatId);
    sendMessage.execute(httpClientService);
  }
}

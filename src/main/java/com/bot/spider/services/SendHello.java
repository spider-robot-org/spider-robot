package com.bot.spider.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  com.bot.spider.libs.telegram.SendMessage;

@Service
public class SendHello {
  //chatId= "2119949077"

  private HttpClientService  httpClientService;

  @Autowired
  public  SendHello(HttpClientService httpClientService) {
    this.httpClientService = httpClientService;
  }

  public void execute(int chatId) {
    SendMessage sendMessage = new SendMessage(chatId);
    sendMessage.execute(httpClientService);
  }
}

package com.bot.spider.services;

import com.bot.spider.dtos.TelegramMessageDTO;
import com.bot.spider.enums.TelegramChatAction;

public class HandlingInputs {
  private HttpClientService httpClientService;
  private TelegramMessageDTO body;

  public HandlingInputs(TelegramMessageDTO body, HttpClientService httpClientService) {
    this.httpClientService = httpClientService;
    this.body = body;
  }

  public void handle() {
    TelegramSenders telegramSenders = new TelegramSenders(httpClientService);

    assert body.message() != null;
    Long chatId = body.message().chat().id();
    String text = body.message().text();

    if (text.equals("/start")) {
      telegramSenders.sendHello(chatId);
    }

    if (text.equals("/typing")) {
      telegramSenders.sendChatAction(chatId, TelegramChatAction.UPLOAD_AUDIO);
    }

  }

}

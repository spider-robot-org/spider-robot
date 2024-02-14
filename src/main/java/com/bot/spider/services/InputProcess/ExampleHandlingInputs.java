package com.bot.spider.services.InputProcess;

import com.bot.spider.dtos.TelegramMessageDTO;
import com.bot.spider.enums.TelegramChatAction;
import com.bot.spider.services.HttpClientService;
import com.bot.spider.services.TelegramSenders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleHandlingInputs {
  private final HttpClientService httpClientService;

  @Autowired
  public ExampleHandlingInputs( HttpClientService httpClientService) {
    this.httpClientService = httpClientService;
  }

  public void handle(TelegramMessageDTO body) {
    TelegramSenders telegramSenders = new TelegramSenders(httpClientService);

    assert body.message().isPresent();
    assert body.message().get().chat().isPresent();

    Long chatId = body.message().get().chat().get().id();
    String text = body.message().get().text();

    if (text.equals("/start")) {
      telegramSenders.sendHello(chatId);
    }

    if (text.equals("/typing")) {
      telegramSenders.sendChatAction(chatId, TelegramChatAction.UPLOAD_AUDIO);
    }

  }

}

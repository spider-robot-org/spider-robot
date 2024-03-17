package com.bot.spider.services.inputprocess;

import com.bot.spider.dtos.TelegramMessageDTO;
import com.bot.spider.services.HttpClientService;
import com.bot.spider.services.TelegramSenders;
import org.springframework.stereotype.Service;

@Service
public class ExampleButtonInput {
  private final HttpClientService httpClientService;
  private       TelegramSenders   telegramSenders;

  public ExampleButtonInput(HttpClientService httpClientService, TelegramSenders telegramSenders) {
    this.httpClientService = httpClientService;
    this.telegramSenders   = telegramSenders;
  }

  public void handle(TelegramMessageDTO.CallbackQueryDTO body) {
    this.telegramSenders = new TelegramSenders(httpClientService);

    body.message().chat().ifPresent(chat -> {
      Long   chatId = chat.id();
      String data   = body.data();

      if ("option_one".equals(data)) {
        telegramSenders.sendAnyMessage("Você escolheu a opção 1", chatId);
      } else if ("option_two".equals(data)) {
        telegramSenders.sendAnyMessage("Você escolheu a opção 3", chatId);
      } else if ("option_three".equals(data)) {
        telegramSenders.sendAnyMessage("Você escolheu a opção 2", chatId);
      } else {
        telegramSenders.sendAnyMessage("UHUUUU", chatId);
      }
    });
  }
}

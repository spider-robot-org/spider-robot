package com.bot.spider.services.InputProcess;

import com.bot.spider.dtos.TelegramMessageDTO;
import com.bot.spider.services.HttpClientService;
import com.bot.spider.services.TelegramSenders;
import org.springframework.stereotype.Service;

@Service
public class ExampleButtonInput {
  private final HttpClientService httpClientService;

  public ExampleButtonInput(HttpClientService httpClientService) {
    this.httpClientService = httpClientService;
  }
  public void handle(TelegramMessageDTO body) {
    TelegramSenders telegramSenders = new TelegramSenders(httpClientService);


    assert body.callback_query().isPresent();

    TelegramMessageDTO.CallbackQueryDTO callbackQuery = body.callback_query().get();

    assert callbackQuery.message().chat().isPresent();

    Long chatId = callbackQuery.message().chat().get().id();
    String data = callbackQuery.data();

    if (data.equals("one_piece_confirm")) {
     telegramSenders.sendAnyMessage("Você escolheu a opção 1", chatId);
    }

    if (data.equals("one_piece_confirm2")) {
      telegramSenders.sendAnyMessage("Você escolheu a opção 3", chatId);
    }

    if (data.equals("one_piece_not_confirm")) {
      telegramSenders.sendAnyMessage("Você escolheu a opção 2", chatId);
    }
  }

}

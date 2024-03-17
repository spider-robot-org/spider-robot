package com.bot.spider.services.inputprocess;

import com.bot.spider.dtos.telegram.update.TelegramUpdateDTO;
import com.bot.spider.enums.TelegramChatAction;
import com.bot.spider.factory.KeyboardFactory;
import com.bot.spider.libs.keyboard.InlineKeyboard;
import com.bot.spider.services.HttpClientService;
import com.bot.spider.services.TelegramSenders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ExampleHandlingInputs {
  private final HttpClientService httpClientService;

  @Autowired
  public ExampleHandlingInputs(HttpClientService httpClientService) {
    this.httpClientService = httpClientService;
  }

  public void handle(Long chatId, String text) {
    TelegramSenders telegramSenders = new TelegramSenders(httpClientService);

    if (text.equals("/start")) {
      telegramSenders.sendHello(chatId);
    }

    if (text.equals("/typing")) {
      telegramSenders.sendChatAction(chatId, TelegramChatAction.UPLOAD_AUDIO);
    }

    if (text.equals("/keyboard")) {
      String messageText = "Escolha uma opção";
      InlineKeyboard button1 = new InlineKeyboard("Texto 1", "option_one");
      InlineKeyboard button2 = new InlineKeyboard("Texto 3", "option_two");
      InlineKeyboard button3 = new InlineKeyboard("Texto 2", "option_three");

      List<InlineKeyboard> row1 = Arrays.asList(button1, button2);
      List<InlineKeyboard> row2 = List.of(button3);

      List<List<InlineKeyboard>> inlineKeyboard = Arrays.asList(row1, row2);

      String json = KeyboardFactory.createKeyboard(chatId, messageText, inlineKeyboard);
      telegramSenders.sendKeyboard(json);
    }
  }
}

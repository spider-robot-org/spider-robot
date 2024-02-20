package com.bot.spider.services.InputProcess;

import com.bot.spider.dtos.TelegramMessageDTO;
import com.bot.spider.enums.TelegramChatAction;
import com.bot.spider.libs.keyboard.CreateKeyboard;
import com.bot.spider.libs.keyboard.InlineKeyboardButton;
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

    if (text.equals(("/keyboard"))) {
      String messageText = "Escolha uma opção";
      InlineKeyboardButton button1 = new InlineKeyboardButton("Texto 1", "one_piece_confirm");
      InlineKeyboardButton button3 = new InlineKeyboardButton("Texto 3", "one_piece_confirm2");
      InlineKeyboardButton button2 = new InlineKeyboardButton("Texto 2", "one_piece_not_confirm");

      List<InlineKeyboardButton> row1 = Arrays.asList(button1, button3);
      List<InlineKeyboardButton> row2 = List.of(button2);

      List<List<InlineKeyboardButton>> inlineKeyboard = Arrays.asList(row1, row2);

      String json = CreateKeyboard.newKeyboard(chatId, messageText, inlineKeyboard);
      telegramSenders.sendKeyboard(json);
    }
  }

}

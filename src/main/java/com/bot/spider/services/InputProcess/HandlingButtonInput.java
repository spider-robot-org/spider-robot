package com.bot.spider.services.InputProcess;

import com.bot.spider.dtos.HandlingButtonInputDTO;
import com.bot.spider.libs.keyboard.CreateKeyboard;
import com.bot.spider.libs.keyboard.InlineKeyboardRow;
import com.bot.spider.services.TelegramSenders;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HandlingButtonInput {
  private final TelegramSenders telegramSenders;
  private final UserMenuManager userMenuManager = UserMenuManager.getInstance();

  public void handle(HandlingButtonInputDTO dto) {
    String data = dto.data();
    Long chatId = dto.id();
    Long messageId = dto.messageId();

    switch (data) {
      case "opt1" -> {
        String json = NavigationMenu.builder()
                .chatId(chatId)
                .messageId(messageId)
                .message("Aqui estão as opções referente a sua escolha 1")
                .rows(1)
                .button(1, "Menu 1", "opt1.1")
                .button(1, "Menu 2", "opt1.2")
                .backButton()
                .build()
                .buildJson();
        userMenuManager.push(chatId, new MenuState(json, messageId));
        telegramSenders.sendReplyMessage(json);
      }
      case "opt1.1" -> {
        String json = NavigationMenu.builder()
                .chatId(chatId)
                .messageId(messageId)
                .message("Você escolheu a opção 1.1")
                .rows(1)
                .backButton()
                .build()
                .buildJson();
        userMenuManager.push(chatId, new MenuState(json, messageId));
        telegramSenders.sendReplyMessage(json);
      }
      case "opt1.2" -> {
        String json = NavigationMenu.builder()
                .chatId(chatId)
                .messageId(messageId)
                .message("Você escolheu a opção 1.2")
                .rows(1)
                .backButton()
                .build()
                .buildJson();
        userMenuManager.push(chatId, new MenuState(json, messageId));
        telegramSenders.sendReplyMessage(json);
      }
      case "opt2" -> {
        String json = NavigationMenu.builder()
                .chatId(chatId)
                .messageId(messageId)
                .message("Aqui estão as opções referente a sua escolha 2")
                .rows(1)
                .button(1, "Menu 1", "opt2.1")
                .button(1, "Menu 2", "opt2.2")
                .backButton()
                .build()
                .buildJson();
        userMenuManager.push(chatId, new MenuState(json, messageId));
        telegramSenders.sendReplyMessage(json);
      }
      case "opt2.1" -> {

        String json = NavigationMenu.builder()
                .chatId(chatId)
                .messageId(messageId)
                .message("Você escolheu a opção 2.1")
                .rows(1)
                .backButton()
                .build()
                .buildJson();
        userMenuManager.push(chatId, new MenuState(json, messageId));
        telegramSenders.sendReplyMessage(json);
      }
      case "opt2.2" -> {

        String json = NavigationMenu.builder()
                .chatId(chatId)
                .messageId(messageId)
                .message("Você escolheu a opção 2.2")
                .rows(1)
                .backButton()
                .build()
                .buildJson();
        userMenuManager.push(chatId, new MenuState(json, messageId));
        telegramSenders.sendReplyMessage(json);
      }
      case "back" -> {
        var currentState = userMenuManager.peek(chatId);
        var previousState = userMenuManager.pop(chatId);

        if (currentState != null) {
          if (currentState.getData().equals(previousState.getData())) {
            previousState = userMenuManager.pop(chatId);
          }

          if (previousState != null) {
            NavigationMenu menu = NavigationMenu.fromJson(previousState.getData());
            menu.setMessageId(messageId);
            String json = menu.buildJson();
            userMenuManager.push(chatId, previousState);
            telegramSenders.sendReplyMessage(json);
          } else {
            telegramSenders.sendAnyMessage("Desculpe, mas parece que tem algo errado", chatId);
          }
        }

      }
    }
  }
}

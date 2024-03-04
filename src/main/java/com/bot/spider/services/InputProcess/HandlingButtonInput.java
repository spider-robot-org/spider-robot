package com.bot.spider.services.InputProcess;

import com.bot.spider.dtos.HandlingButtonInputDTO;
import com.bot.spider.services.TelegramSenders;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HandlingButtonInput {
  private final TelegramSenders telegramSenders;

  public void handle(HandlingButtonInputDTO dto) {
    String data = dto.data();
    Long chatId = dto.id();
    Long messageId = dto.messageId();

    switch (data) {
      case "opt1" -> {
        String json = NavigationMenu.builder()
                .chatId(chatId)
                .messageId(messageId)
                .message("Aqui estão as opções referente a sua escolha")
                .rows(1)
                .button(1, "Oi", "opt2")
                .build()
                .buildJson();
        telegramSenders.sendReplyMessage(json);
      }
      case "opt2" -> {
        String json = NavigationMenu.builder()
                .chatId(chatId)
                .messageId(messageId)
                .rows(1)
                .message("Outras opções")
                .button(1, "Opção 1", "opt1")
                .build()
                .buildJson();
        telegramSenders.sendReplyMessage(json);
      }
    }
  }
}

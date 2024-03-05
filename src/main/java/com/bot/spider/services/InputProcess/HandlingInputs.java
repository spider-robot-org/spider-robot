package com.bot.spider.services.InputProcess;

import com.bot.spider.dtos.HandlingInputsDTO;
import com.bot.spider.models.SessionModel;
import com.bot.spider.services.HttpClientService;
import com.bot.spider.services.TelegramSenders;
import com.bot.spider.utils.Sessions;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class HandlingInputs {
  private HttpClientService httpClientService;
  private TelegramSenders telegramSenders = new TelegramSenders(httpClientService);

  public void handle(HandlingInputsDTO dto) {
    Long chatId = dto.chatId();
    String text = dto.text();

    switch (text) {
      case "/start" -> telegramSenders.sendAnyMessage(text, chatId);
      case "/typing" -> telegramSenders.sendHello(chatId);
      case "/keyboard" -> {
        if (dto.chat().isPresent()) {
          String json = NavigationMenu.buildInitialMenu(chatId, dto.chat().get().first_name());
          telegramSenders.sendKeyboard(json);
        }
      }
      case "new" -> {
        SessionModel database = new SessionModel();
        database.setStage("Testing");
        database.setStep(20);
        database.setId(chatId);

        Sessions sessions = new Sessions();
        sessions.save(database);

        telegramSenders.sendAnyMessage("Salvo", chatId);
      }

      case "update" -> {
        SessionModel database = new SessionModel();
        database.setStage("Testing2");
        database.setStep(10);
        database.setId(chatId);

        Sessions sessions = new Sessions();
        sessions.update(database);

        telegramSenders.sendAnyMessage("Atualizado", chatId);
      }

      case "delete" -> {
        Sessions sessions = new Sessions();
        sessions.delete(chatId);

        telegramSenders.sendAnyMessage("Deletado", chatId);
      }

      case "find" -> {
        Sessions sessions = new Sessions();
        SessionModel database = sessions.findById(chatId);

        if (database == null) {
          telegramSenders.sendAnyMessage("Não encontrado", chatId);
          return;
        }

        telegramSenders.sendAnyMessage("stage atual: " + database.getStage(), chatId);
      }

      default -> telegramSenders.sendAnyMessage("Não entendi", chatId);
    }
  }
}

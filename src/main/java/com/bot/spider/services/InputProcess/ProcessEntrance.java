package com.bot.spider.services.InputProcess;

import com.bot.spider.dtos.HandlingButtonInputDTO;
import com.bot.spider.dtos.telegram.update.CallbackQueryDTO;
import com.bot.spider.dtos.telegram.update.MessageDTO;
import org.springframework.stereotype.Service;

import com.bot.spider.dtos.HandlingInputsDTO;
import com.bot.spider.dtos.telegram.update.TelegramUpdateDTO;

import lombok.AllArgsConstructor;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProcessEntrance {
  private final ExampleButtonInput exampleButtonInput;
  private final HandlingInputs handlingInputs;
  private final HandlingButtonInput handlingButtonInput;

  public void process(TelegramUpdateDTO body) {
    Optional<MessageDTO> message = body.message();
    Optional<CallbackQueryDTO> callbackQueryDTO = body.callback_query();

    if (message.isEmpty() && callbackQueryDTO.isEmpty()) {
      return;
    }

    if (message.isPresent()) {
      if (message.get().forward_origin().isPresent()) {
        return;
      }
      handlingInputs.handle(new HandlingInputsDTO(body));

    } else if (callbackQueryDTO.isPresent()) {
      handlingButtonInput.handle(new HandlingButtonInputDTO(body));
    }
  }
}

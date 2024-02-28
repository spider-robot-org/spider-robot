package com.bot.spider.services.InputProcess;

import org.springframework.stereotype.Service;

import com.bot.spider.dtos.HandlingInputsDTO;
import com.bot.spider.dtos.telegram.update.TelegramUpdateDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProcessEntrance {
	private final ExampleButtonInput exampleButtonInput;
	private final HandlingInputs handlingInputs;

  public void process(TelegramUpdateDTO body) {
    if (body.message().isEmpty() && body.callback_query().isEmpty()) {
      return;
    }

    if (body.message().isPresent()) {

      if (body.message().get().forward_origin().isPresent()) {
        //
        return;
      }
	//   handlingInputs.handle(new HandlingInputsDTO(body));
    //   exampleHandlingInputs.handle(body);

    } else if (body.callback_query().isPresent()) {
      exampleButtonInput.handle(body);
    }
  }
}

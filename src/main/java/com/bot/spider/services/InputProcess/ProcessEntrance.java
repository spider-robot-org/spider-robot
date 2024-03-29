package com.bot.spider.services.InputProcess;

import com.bot.spider.dtos.telegram.update.TelegramUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessEntrance {
  private final ExampleHandlingInputs exampleHandlingInputs;
  private final ExampleButtonInput exampleButtonInput;

  @Autowired
  public ProcessEntrance(ExampleHandlingInputs exampleHandlingInputs, ExampleButtonInput exampleButtonInput) {
    this.exampleHandlingInputs = exampleHandlingInputs;
    this.exampleButtonInput = exampleButtonInput;
  }

  public void process(TelegramUpdateDTO body) {
    if (body.message().isEmpty() && body.callback_query().isEmpty()) {
      return;
    }

    if (body.message().isPresent()) {

      if (body.message().get().forward_origin().isPresent()) {
        //
        return;
      }
      exampleHandlingInputs.handle(body);

    } else if (body.callback_query().isPresent()) {
      exampleButtonInput.handle(body);
    }
  }
}

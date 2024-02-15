package com.bot.spider.services.InputProcess;

import com.bot.spider.dtos.TelegramMessageDTO;
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

  public void process(TelegramMessageDTO body) {
    if (body.message().isEmpty() && body.callback_query().isEmpty()) {
      return;
    }

    if (body.message().isPresent()) {
      exampleHandlingInputs.handle(body);

    } else if (body.callback_query().isPresent()) {
      exampleButtonInput.handle(body);
    }
  }
}

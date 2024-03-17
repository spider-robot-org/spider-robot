package com.bot.spider.services.inputprocess;

import com.bot.spider.dtos.TelegramMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

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
    AtomicLong              chatId = new AtomicLong();
    AtomicReference<String> text   = new AtomicReference<>();

//    body.message().ifPresent(message -> {
//      text.set(message.text());
//      message.chat().ifPresent(chat -> chatId.set(chat.id()));
//      exampleHandlingInputs.handle(chatId.get(), text.get());
//    });

    body.callback_query().ifPresent(callbackQueryDTO -> {
      text.set(callbackQueryDTO.message().text());
      callbackQueryDTO.message().chat().ifPresent(chatDTO -> {
        chatId.set(chatDTO.id());
        exampleHandlingInputs.handle(chatId.get(), text.get());
      });
    });

    body.callback_query().ifPresent(exampleButtonInput::handle);
  }
}

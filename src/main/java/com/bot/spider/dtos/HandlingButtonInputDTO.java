package com.bot.spider.dtos;

import com.bot.spider.dtos.telegram.update.TelegramUpdateDTO;

public record HandlingButtonInputDTO(String data, Long id, Long messageId) {
  public HandlingButtonInputDTO(TelegramUpdateDTO dto) {
    this(dto.callback_query().get().data(), dto.callback_query().get().message().chat().get().id(), dto.callback_query().get().message().message_id());
  }
}

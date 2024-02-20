package com.bot.spider.dtos;

import java.util.Optional;

import com.bot.spider.dtos.TelegramMessageDTO.ChatDTO;

public record HandlingInputsDTO(Long chatId, String text, Optional<ChatDTO> chat) {
	public HandlingInputsDTO(TelegramMessageDTO body) {
		this(body.message().get().chat().get().id(), body.message().get().text(), body.message().get().chat());
	}
}

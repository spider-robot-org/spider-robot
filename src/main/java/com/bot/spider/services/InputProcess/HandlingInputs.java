package com.bot.spider.services.InputProcess;

import org.springframework.stereotype.Service;

import com.bot.spider.dtos.HandlingInputsDTO;
import com.bot.spider.services.HttpClientService;
import com.bot.spider.services.TelegramSenders;

import lombok.AllArgsConstructor;

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
		}
	}
}

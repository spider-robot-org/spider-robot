package com.bot.spider.services.InputProcess;

import org.springframework.stereotype.Service;

import com.bot.spider.dtos.HandlingInputsDTO;
import com.bot.spider.dtos.TelegramMessageDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProcessEntrance {
	private final ExampleHandlingInputs exampleHandlingInputs;
	private final ExampleButtonInput exampleButtonInput;
	private final HandlingInputs handlingInputs;

	public void process(TelegramMessageDTO body) {
		var message = body.message();
		var callbackQuery = body.callback_query();

		if (message.isPresent()) {
			handlingInputs.handle(new HandlingInputsDTO(body));
			exampleHandlingInputs.handle(body);

		} else if (callbackQuery.isPresent()) {
			exampleButtonInput.handle(body);
		}
	}
}

package com.bot.spider.services.InputProcess;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bot.spider.dtos.NavigationMenuDTO;
import com.bot.spider.libs.keyboard.CreateKeyboard;
import com.bot.spider.libs.keyboard.InlineKeyboard;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NavigationMenu {
	public String createMenu(NavigationMenuDTO dto) {
		Long chatId = dto.chatId();

		String username = dto.username();
		String messageText = "Olá " + username;

		InlineKeyboard button = new InlineKeyboard("Texto 1", "opt1");
		InlineKeyboard button2 = new InlineKeyboard("Texto 2", "opt2");

		List<InlineKeyboard> row1 = Arrays.asList(button, button2);
		List<List<InlineKeyboard>> inlineKeyboard = Arrays.asList(row1);

		String json = CreateKeyboard.newKeyboard(chatId, messageText, inlineKeyboard);
		return json;		
	}
}

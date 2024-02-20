package com.bot.spider.services.InputProcess;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bot.spider.dtos.NavigationMenuDTO;
import com.bot.spider.libs.keyboard.CreateKeyboard;
import com.bot.spider.libs.keyboard.InlineKeyboardButton;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NavigationMenu {
	public String createMenu(NavigationMenuDTO dto) {
		Long chatId = dto.chatId();

		String username = dto.username();
		String messageText = "Olá " + username;

		InlineKeyboardButton button = new InlineKeyboardButton("Texto 1", "opt1");
		InlineKeyboardButton button2 = new InlineKeyboardButton("Texto 2", "opt2");

		List<InlineKeyboardButton> row1 = Arrays.asList(button, button2);
		List<List<InlineKeyboardButton>> inlineKeyboard = Arrays.asList(row1);

		String json = CreateKeyboard.newKeyboard(chatId, messageText, inlineKeyboard);
		return json;		
	}
}

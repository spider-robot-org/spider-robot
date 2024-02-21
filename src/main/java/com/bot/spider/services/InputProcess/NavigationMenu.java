package com.bot.spider.services.InputProcess;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.bot.spider.dtos.NavigationMenuDTO;
import com.bot.spider.libs.keyboard.CreateKeyboard;
import com.bot.spider.libs.keyboard.InlineKeyboard;
import com.bot.spider.libs.keyboard.InlineKeyboardButton;
import com.bot.spider.libs.keyboard.InlineKeyboardRow;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NavigationMenu {
	public String createMenu(NavigationMenuDTO dto) {
		Long chatId = dto.chatId();

		String username = dto.username();
		String messageText = String.format("Olá, %s! Por favor, utilize os botões abaixo para navegar entre as funcionalidades disponíveis.", username);

		InlineKeyboardButton button = new InlineKeyboardButton("Texto 1", "opt1");
		InlineKeyboardButton button2 = new InlineKeyboardButton("Texto 2", "opt2");

		InlineKeyboardRow row1 = new InlineKeyboardRow(Arrays.asList(button, button2));
		InlineKeyboard inlineKeyboard = new InlineKeyboard(Arrays.asList(row1));

		String json = CreateKeyboard.newKeyboard(chatId, messageText, inlineKeyboard);
		return json;		
	}
}

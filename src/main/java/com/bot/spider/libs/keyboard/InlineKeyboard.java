package com.bot.spider.libs.keyboard;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InlineKeyboard {
	List<InlineKeyboardRow> keyboardRows;
	
	public List<List<InlineKeyboardButton>> toListOfLists() {
        return keyboardRows.stream()
				.map(InlineKeyboardRow::buttons)
				.collect(Collectors.toList());
    }
}

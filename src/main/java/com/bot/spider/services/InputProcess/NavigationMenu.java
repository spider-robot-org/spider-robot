package com.bot.spider.services.InputProcess;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bot.spider.libs.keyboard.CreateKeyboard;
import com.bot.spider.libs.keyboard.InlineKeyboard;
import com.bot.spider.libs.keyboard.InlineKeyboardButton;
import com.bot.spider.libs.keyboard.InlineKeyboardRow;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Service
public class NavigationMenu {
	private Long chatId;
	private String message;
	private List<InlineKeyboardRow> rows;

	public static NavigationMenuBuilder builder() {
		return new NavigationMenuBuilder();
	}

	public static class NavigationMenuBuilder {
		private Long chatId;
		private String message;
		private List<InlineKeyboardRow> rows = new ArrayList<>();

		public NavigationMenuBuilder chatId(Long chatId) {
			this.chatId = chatId;
			return this;
		}

		public NavigationMenuBuilder message(String message) {
			this.message = message;
			return this;
		}

		public NavigationMenuBuilder rows(int lines) {
			for (int i = 0; i < lines; i++) {
				rows.add(new InlineKeyboardRow(new ArrayList<>()));
			}
			return this;
		}

		public NavigationMenuBuilder button(int line, String text, String data) {
			if (line < rows.size()) {
				rows.get(line).buttons().add(new InlineKeyboardButton(text, data));
			}
			return this;
		}

		public NavigationMenu build() {
			return new NavigationMenu(chatId, message, rows);
		}
	}

	public String buildJson() {
		InlineKeyboard inlineKeyboard = new InlineKeyboard(this.rows);
		return CreateKeyboard.newKeyboard(this.chatId, this.message, inlineKeyboard);
	}

	public static String buildInitialMenu(Long chatId, String firstName) {
		return NavigationMenu.builder()
				.chatId(chatId)
				.message(
						"Olá %s! Por favor, utilize os botões abaixo para navegar entre as funcionalidades disponíveis."
								.formatted(firstName))
				.rows(2)
				.button(0, "Opção 1", "opt1")
				.button(1, "Opção 2", "opt2")
				.build()
				.buildJson();
	}
}
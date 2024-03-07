package com.bot.spider.services.InputProcess;

import com.bot.spider.libs.keyboard.CreateKeyboard;
import com.bot.spider.libs.keyboard.InlineKeyboard;
import com.bot.spider.libs.keyboard.InlineKeyboardButton;
import com.bot.spider.libs.keyboard.InlineKeyboardRow;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Service
public class NavigationMenu {
	private Long chatId;
	private String message;
	private List<InlineKeyboardRow> rows;
	private Long messageId;

	public NavigationMenu(MessageKeyboard messageKeyboard) {
		this.chatId = messageKeyboard.chatId();
		this.message = messageKeyboard.text();
		this.messageId = messageKeyboard.messageId();
		this.rows = new ArrayList<>();
		for (List<InlineKeyboardButton> buttons : messageKeyboard.replyMarkup().inlineKeyboard()) {
			this.rows.add(new InlineKeyboardRow(buttons));
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		NavigationMenu that = (NavigationMenu) obj;
		return chatId == that.chatId &&
						message.equals(that.message) &&
						messageId.equals(that.messageId);
	}

	public static NavigationMenu fromJson(String json) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			var message = objectMapper.readValue(json, MessageKeyboard.class);
			return new NavigationMenu(message);
		} catch (IOException e) {
			throw new RuntimeException("Failed to convert JSON to NavigationMenu", e);
		}
	}
	public static NavigationMenuBuilder builder() {
		return new NavigationMenuBuilder();
	}

	public static class NavigationMenuBuilder {
		private Long chatId;
		private String message;
		private final List<InlineKeyboardRow> rows = new ArrayList<>();
		private Long messageId;

		public NavigationMenuBuilder chatId(Long chatId) {
			this.chatId = chatId;
			return this;
		}

		public NavigationMenuBuilder messageId(Long messageId) {
			this.messageId = messageId;
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
			int zeroBasedLine = line - 1;
			if (zeroBasedLine < rows.size()) {
				rows.get(zeroBasedLine).buttons().add(new InlineKeyboardButton(text, data));
			}
			return this;
		}

		public NavigationMenuBuilder backButton() {
			if (!rows.isEmpty()) {
				rows.get(rows.size() - 1).buttons().add(new InlineKeyboardButton("Voltar", "back"));
			}
			return this;
		}

		public NavigationMenu build() {
			return new NavigationMenu(chatId, message, rows, messageId);
		}
	}

	public String buildJson() {
		InlineKeyboard inlineKeyboard = new InlineKeyboard(this.rows);
		if (messageId != null) {
			return CreateKeyboard.newKeyboard(chatId, messageId, message, inlineKeyboard);
		}
		return CreateKeyboard.newKeyboard(chatId, message, inlineKeyboard);
	}

	public static String buildInitialMenu(Long chatId, String firstName) {
		return NavigationMenu.builder()
				.chatId(chatId)
				.message(
						"Olá %s! Por favor, utilize os botões abaixo para navegar entre as funcionalidades disponíveis."
								.formatted(firstName))
				.rows(2)
				.button(1, "Opção 1", "opt1")
				.button(2, "Opção 2", "opt2")
				.build()
				.buildJson();
	}
}
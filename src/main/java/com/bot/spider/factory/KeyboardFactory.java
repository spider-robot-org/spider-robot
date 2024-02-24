package com.bot.spider.factory;

import com.bot.spider.libs.keyboard.InlineKeyboard;
import com.bot.spider.libs.keyboard.KeyboardList;
import com.bot.spider.libs.keyboard.Message;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class KeyboardFactory {

    private KeyboardFactory() {
    }

    public static String createKeyboard(Long chatId, String messageText, List<List<InlineKeyboard>> inlineKeyboard) {
        Message message = new Message(chatId, messageText, new KeyboardList(inlineKeyboard));

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(message);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

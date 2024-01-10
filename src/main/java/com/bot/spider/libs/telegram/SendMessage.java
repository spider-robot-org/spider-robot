package com.bot.spider.libs.telegram;

import com.bot.spider.interfaces.TelegramApiMethod;
import com.bot.spider.services.HttpClientService;

public class SendMessage implements TelegramApiMethod {
    private final Long chatId;

    public SendMessage(Long chatId) {
        this.chatId = chatId;
    }

    @Override
    public void execute(HttpClientService httpClientService) {
        String method = "sendMessage";

        String jsonBody = String.format("{\"chat_id\":\"%s\",\"text\":\"Olá! Esta é uma resposta do bot.\"}", this.chatId);

        try {
            httpClientService.sendPostRequest(method, jsonBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

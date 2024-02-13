package com.bot.spider.libs.telegram;

import com.bot.spider.enums.TelegramChatAction;
import com.bot.spider.services.HttpClientService;

public class TelegramApi   {
    private  HttpClientService httpClientService;

    public  TelegramApi( HttpClientService httpClientService) {
        this.httpClientService = httpClientService;
    }

    public  void sendMessage(String jsonBody) {
        String method = "sendMessage";
        sendRequest(method, jsonBody);
    }
    public  void sendChatAction(long chat_id, TelegramChatAction action) {
        String method = "sendChatAction";

        String jsonBody = String.format("{\"chat_id\":\"%s\",\"action\":\"%s\"}", chat_id, action.getAction());
        sendRequest(method, jsonBody);
    }
    public  void sendVideo(long chat_id, String video_url) {
        String method = "sendVideo";
        String jsonBody = String.format("{\"chat_id\":\"%s\",\"video\":\"%s\"}", chat_id, video_url);
        sendRequest(method, jsonBody);
    }
    public  void  getFile (String file_id) {
        String method = "getFile";
        String jsonBody = String.format("{\"file_id\":\"%s\"}", file_id);
        sendRequest(method, jsonBody);
    }
    public void sendRequest(String method, String jsonBody) {
        try {
            httpClientService.sendPostRequest(method, jsonBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

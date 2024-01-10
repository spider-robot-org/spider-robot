package com.bot.spider.interfaces;

import com.bot.spider.services.HttpClientService;

public interface TelegramApiMethod {
  void execute(HttpClientService httpClientService) throws Exception;
}

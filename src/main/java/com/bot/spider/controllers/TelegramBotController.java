package com.bot.spider.controllers;

import com.bot.spider.dtos.TelegramMessageDTO;
import com.bot.spider.services.HttpClientService;
import com.bot.spider.services.SendHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
public class TelegramBotController {
  private final HttpClientService httpClientService;
  Logger logger = Logger.getLogger(getClass().getName());

  @Autowired
  public TelegramBotController(HttpClientService httpClientService) {
    this.httpClientService = httpClientService;
  }

  @PostMapping("${telegram.bot.webhook-path}")
  public ResponseEntity<String> webhook(@RequestBody TelegramMessageDTO body) {
    logger.info(String.valueOf(body));

    assert body.message() != null;
    Long chatId = body.message().chat().id();
    String text = body.message().text();

    try {
      SendHello sendHello = new SendHello(httpClientService);
      sendHello.execute(chatId);
      return new ResponseEntity<>("ok", HttpStatus.OK);
    }
    catch (Exception e){
      logger.log(Level.SEVERE, "Error sending message to chatId: " + chatId);
      return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @RequestMapping("/")
  public String index() {
    return "Greetings from Spring Boot!";
  }
}
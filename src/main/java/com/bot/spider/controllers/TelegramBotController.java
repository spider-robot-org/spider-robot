package com.bot.spider.controllers;

import com.bot.spider.dtos.TelegramMessageDTO;
import com.bot.spider.services.HttpClientService;
import com.bot.spider.services.SendHello;
import org.springframework.beans.factory.annotation.Autowired;
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
  public String webhook(@RequestBody TelegramMessageDTO body) {


    logger.info(String.valueOf(body));


    assert body.message() != null;
    int chatId = body.message().chat().id();
    String text = body.message().text();

    if()

    if (body.message().text().equals("/start")) {
      logger.info("Start command received");
      return "ok";
    }

    if (body.message().text().equals("/commands")) {
      logger.info("Commands command received");
      return "ok";
    }

    if (body.message().text().equals("/help")) {
      logger.info("Help command received");
      return "ok";
    }

    if (body.message().text().equals("/about")) {
      logger.info("About command received");
      return "ok";
    }


    if(body.message().text().equals("/stop")){
      logger.info("Stop command received");
      return "ok";
    }

    try {

      SendHello sendHello = new SendHello(httpClientService);
      sendHello.execute(chatId);
      return "ok";
    }
    catch (Exception e){
      logger.log(Level.SEVERE, "Error sending message to chatId: " + chatId);
      return "ok";
    }
  }

  @RequestMapping("/")
  public String index() {
    return "Greetings from Spring Boot!";
  }
}
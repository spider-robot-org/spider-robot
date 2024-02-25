package com.bot.spider.controllers;

import com.bot.spider.dtos.telegram_update.TelegramUpdateDTO;
import com.bot.spider.services.InputProcess.ProcessEntrance;
import com.bot.spider.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class TelegramBotController {
  Logger logger = Logger.getLogger(getClass().getName());

  @Autowired
  private TokenService tokenService;
  @Autowired
  private ProcessEntrance processEntrance;

  @PostMapping("${telegram.bot.webhook-path}")
  public ResponseEntity<String> webhook(@RequestHeader(value = "X-Telegram-Bot-Api-Secret-Token") String token, @RequestBody TelegramUpdateDTO body) {
    try {

      tokenService.validateToken(token);
      processEntrance.process(body);


      return new ResponseEntity<>("ok", HttpStatus.OK);
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Error : " + e.getMessage(), e);
      return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @RequestMapping("/")
  public String index() {
    return "Application is alive!";
  }
}
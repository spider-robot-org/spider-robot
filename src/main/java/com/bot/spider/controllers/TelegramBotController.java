package com.bot.spider.controllers;

import com.bot.spider.dtos.TelegramMessageDTO;
import com.bot.spider.services.TokenService;
import com.bot.spider.services.inputprocess.ProcessEntrance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class TelegramBotController {
    private static final Logger logger = Logger.getLogger(TelegramBotController.class.getName());
    private final TokenService tokenService;
    private final ProcessEntrance processEntrance;

    @Autowired
    public TelegramBotController(TokenService tokenService, ProcessEntrance processEntrance) {
        this.tokenService = tokenService;
        this.processEntrance = processEntrance;
    }

    @PostMapping("${telegram.bot.webhook-path}")
    public ResponseEntity<String> webhook(@RequestHeader(value= "X-Telegram-Bot-Api-Secret-Token") String token , @RequestBody TelegramUpdateDTO body) {
        try {
            tokenService.validateToken(token);
            processEntrance.process(body);
            return new ResponseEntity<>("ok", HttpStatus.OK);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error: ", e);
            return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/")
    public String index() {
        return "Application is alive!";
    }
}

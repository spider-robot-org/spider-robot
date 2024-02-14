package com.bot.spider.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bot.spider.dtos.TelegramMessageDTO;
import com.bot.spider.services.HandlingInputs;
import com.bot.spider.services.HttpClientService;


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

        try {
            HandlingInputs handlingInputs = new HandlingInputs(body, httpClientService);
            handlingInputs.handle();

            return new ResponseEntity<>("ok", HttpStatus.OK);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error : " + e.getMessage(), e);
            return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
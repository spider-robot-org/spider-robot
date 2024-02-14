package com.bot.spider.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
  @Value("${telegram.bot.secret-token}")
  private  String secretToken;

  public  void validateToken(String token) {

    if(token.isEmpty()) {
      throw new IllegalArgumentException("Token is empty");
    }

    boolean isValid = token.equals(secretToken);

    if(!isValid) {
      throw new IllegalArgumentException("Token is invalid");
    }
  }
}


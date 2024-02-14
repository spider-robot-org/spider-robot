package com.bot.spider.services;

import org.springframework.beans.factory.annotation.Value;

public class TokenService {
  @Value("${telegram.bot.secret-token}")
  private static String secretToken;
  public  static void validateToken(String token) {
    if(token.isEmpty()) {
      throw new IllegalArgumentException("Token is empty");
    }
    boolean isValid = token.equals(secretToken);

    if(!isValid) {
      throw new IllegalArgumentException("Token is invalid");
    }
  }
}


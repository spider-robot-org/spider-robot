package com.bot.spider.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;
import java.util.stream.Collectors;


@Component
public class ResponseLoggingInterceptor implements HandlerInterceptor {

  private static final Logger logger = LoggerFactory.getLogger(ResponseLoggingInterceptor.class);

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    logger.info("RESPONSE STATUS: {}", response.getStatus());
  }

}

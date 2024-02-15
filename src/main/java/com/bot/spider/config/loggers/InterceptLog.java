package com.bot.spider.config.loggers;

import com.bot.spider.services.Logging.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class InterceptLog implements HandlerInterceptor {

  @Autowired
  LoggingService loggingService;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    if(request.getMethod().equals(HttpMethod.GET.name())
            || request.getMethod().equals(HttpMethod.DELETE.name())
            || request.getMethod().equals(HttpMethod.PUT.name()))    {
      loggingService.displayReq(request,null);
    }
    return true;
  }
}

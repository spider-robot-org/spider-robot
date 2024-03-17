package com.bot.spider.config.loggers;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class CustomWebConfigurer implements WebMvcConfigurer {

  private final InterceptLog logInterceptor;

  public CustomWebConfigurer(InterceptLog logInterceptor) {
    this.logInterceptor = logInterceptor;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(logInterceptor);
  }
}

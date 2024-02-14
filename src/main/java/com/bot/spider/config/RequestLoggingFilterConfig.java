package com.bot.spider.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class RequestLoggingFilterConfig {

   @Bean
    public FilterRegistrationBean<CommonsRequestLoggingFilter> loggingFilter(){
    FilterRegistrationBean<CommonsRequestLoggingFilter> registrationBean = new FilterRegistrationBean<>();

    CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();

     loggingFilter.setIncludeQueryString(true);
     loggingFilter.setIncludePayload(true);
     loggingFilter.setMaxPayloadLength(10000);
     loggingFilter.setIncludeHeaders(true);
     loggingFilter.setBeforeMessagePrefix("Bot Request: ");

    registrationBean.setFilter(loggingFilter);
    registrationBean.addUrlPatterns("/*");
    registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);

    return registrationBean;
  }

}


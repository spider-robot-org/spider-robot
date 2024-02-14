package com.bot.spider.services.Logging;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public interface LoggingService {

  void displayReq(HttpServletRequest request, Object body);

  void displayResp(HttpServletRequest request, HttpServletResponse response, Object body);
}


package com.bot.spider.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpClientService {
  @Value("${telegram.bot.token}")
  private String botToken;

  @Value("${telegram.bot.api-url}")
  private String apiUrl;



  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  private final RestTemplate restTemplate = restTemplate();

  public String sendPostRequest(String method, String jsonBody) throws Exception {
    String url = apiUrl + botToken + "/" + method;

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<String> requestEntity = new HttpEntity<>(jsonBody, headers);
    ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);


    return responseEntity.getBody();
  }
}

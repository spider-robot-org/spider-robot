package com.bot.spider.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SessionModel {
  private Long id;
  private String stage;
  private int step;
}

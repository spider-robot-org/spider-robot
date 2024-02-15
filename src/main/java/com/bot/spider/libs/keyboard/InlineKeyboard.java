package com.bot.spider.libs.keyboard;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record InlineKeyboard(String text, String callback_data) {

  @JsonCreator
  public InlineKeyboard(@JsonProperty("text") String text, @JsonProperty("callback_data") String callback_data) {
    this.text = text;
    this.callback_data = callback_data;
  }
}
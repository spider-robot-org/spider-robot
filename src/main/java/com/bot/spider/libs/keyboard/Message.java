package com.bot.spider.libs.keyboard;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {

  private final Long chatId;
  private final KeyboardList replyMarkup;
  private final String text;

  @JsonCreator
  public Message(Long chatId, @JsonProperty("text") String text, @JsonProperty("reply_markup") KeyboardList createKeyboard) {
    this.chatId = chatId;
    this.replyMarkup = createKeyboard;
    this.text = text;
  }
}

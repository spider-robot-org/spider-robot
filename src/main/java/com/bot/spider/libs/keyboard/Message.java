package com.bot.spider.libs.keyboard;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {

  private final Long chat_id;
  private final KeyboardList reply_markup;
  private final String text;

  @JsonCreator
  public Message(Long chatId, @JsonProperty("text") String text, @JsonProperty("reply_markup") KeyboardList createKeyboard) {
    this.chat_id = chatId;
    this.reply_markup = createKeyboard;
    this.text = text;
  }
}

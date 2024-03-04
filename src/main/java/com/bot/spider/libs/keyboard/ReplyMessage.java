package com.bot.spider.libs.keyboard;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ReplyMessage {
  @JsonProperty("chat_id")
  private Long chatId;

  @JsonProperty("message_id")
  private Long messageId;

  @JsonProperty("reply_markup")
  private KeyboardList replyMarkup;
  private String text;

  @JsonCreator
  public ReplyMessage(Long chatId, Long messageId, KeyboardList replyMarkup) {
    this.chatId = chatId;
    this.messageId = messageId;
    this.replyMarkup = replyMarkup;
  }

  @JsonCreator
  public ReplyMessage(Long chatId, Long messageId, String text, KeyboardList replyMarkup) {
    this.chatId = chatId;
    this.messageId = messageId;
    this.text = text;
    this.replyMarkup = replyMarkup;
  }
}

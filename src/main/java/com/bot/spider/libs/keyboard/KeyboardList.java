package com.bot.spider.libs.keyboard;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class KeyboardList {
  private final List<List<InlineKeyboardButton>> inline_keyboard;

  @JsonCreator
  public KeyboardList(@JsonProperty("inline_keyboard") List<List<InlineKeyboardButton>> inlineKeyboard) {
    this.inline_keyboard = inlineKeyboard;
  }
}
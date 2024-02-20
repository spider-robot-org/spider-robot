package com.bot.spider.libs.keyboard;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KeyboardList {
  private final InlineKeyboard inline_keyboard;

  @JsonCreator
  public KeyboardList(@JsonProperty("inline_keyboard") InlineKeyboard inlineKeyboard) {
    this.inline_keyboard = inlineKeyboard;
  }
}
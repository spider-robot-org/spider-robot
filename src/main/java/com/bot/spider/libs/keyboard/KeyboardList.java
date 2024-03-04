package com.bot.spider.libs.keyboard;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class KeyboardList {
  private final List<List<InlineKeyboardButton>> inline_keyboard;

  @JsonCreator
  public KeyboardList(@JsonProperty("inline_keyboard") InlineKeyboard inlineKeyboard) {
    this.inline_keyboard = inlineKeyboard.toListOfLists();
  }
}
package com.bot.spider.services.InputProcess;

import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@Component
@ToString
public class UserMenuManager {
  private static UserMenuManager instance = null;
  private final Map<Long, Stack<MenuState>> state = new HashMap<>();

  private UserMenuManager() {}

  public static UserMenuManager getInstance() {
    if (instance == null) {
      instance = new UserMenuManager();
    }
    return instance;
  }

  public void push(Long chatId, MenuState menuState) {
    state.putIfAbsent(chatId, new Stack<>());
    state.get(chatId).push(menuState);
  }

  public MenuState pop(Long chatId) {
    Stack<MenuState> menuStates = state.get(chatId);
    return (menuStates == null || menuStates.isEmpty()) ? null : menuStates.pop();
  }

  public MenuState peek(Long chatId) {
    Stack<MenuState> menuStates = state.get(chatId);
    return (menuStates == null || menuStates.isEmpty()) ? null : menuStates.peek();
  }
}

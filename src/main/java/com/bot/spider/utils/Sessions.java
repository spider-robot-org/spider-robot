package com.bot.spider.utils;

import com.bot.spider.models.SessionModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Sessions {
  private final String JSON_FILE = "src/main/resources/data/sessions.json";
  private final ObjectMapper objectMapper = new ObjectMapper();

  public List<SessionModel> findAll() {
    try {
      File file = new File(JSON_FILE);
      if (!file.exists() || file.length() == 0) {
        return new ArrayList<>();
      }
      return objectMapper.readValue(file, new TypeReference<List<SessionModel>>() {
      });
    } catch (IOException e) {
      e.printStackTrace();
      return new ArrayList<>();
    }
  }

  public SessionModel findById(Long id) {
    Optional<SessionModel> optionalDatabase = findAll().stream()
            .filter(database -> database.getId().equals(id))
            .findFirst();
    return optionalDatabase.orElse(null);
  }

  public void save(SessionModel database) {
    if (findById(database.getId()) == null) {
      List<SessionModel> result = findAll();
      result.add(database);
      saveAll(result);
    } else {
      System.out.println("ID already exists. Cannot save.");
    }
  }

  public void update(SessionModel database) {
    if (findById(database.getId()) != null) {
      List<SessionModel> result = findAll();
      for (int i = 0; i < result.size(); i++) {
        if (result.get(i).getId().equals(database.getId())) {
          result.set(i, database);
          saveAll(result);
          return;
        }
      }
    } else {
      System.out.println("ID does not exist. Cannot update.");
    }
  }

  public void delete(Long id) {
    if (findById(id) != null) {
      List<SessionModel> result = findAll();
      result.removeIf(database -> database.getId().equals(id));
      saveAll(result);
    } else {
      System.out.println("ID does not exist. Cannot delete.");
    }
  }

  private void saveAll(List<SessionModel> databases) {
    try {
      objectMapper.writeValue(new File(JSON_FILE), databases);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

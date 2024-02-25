package com.bot.spider.services;

import com.bot.spider.enums.Role;
import com.bot.spider.enums.UserStatus;
import com.bot.spider.models.UserModel;
import com.bot.spider.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Objects;

@Component
public class InitializationService implements CommandLineRunner {

    private final UserRepository userRepository;

    private final ObjectMapper objectMapper;

    @Value("${telegram.bot.owners}")
    private String ownersJsonString;

    @Autowired
    public InitializationService(UserRepository userRepository, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args){
                if (!ownersJsonString.isEmpty()){
                    try {
                        List<Map<String, Object>> ownersFromFile = objectMapper.readValue(
                                ownersJsonString,
                                new TypeReference<>() {
                                }
                        );

                    for (Map<String, Object> ownerData : ownersFromFile) {
                        String firstName = (String) ownerData.get("firstName");
                        String lastName = (String) ownerData.get("lastName");
                        String username = (String) ownerData.get("username");


                        UserModel existingOwner = userRepository.findByUsername(username);

                        if (Objects.isNull(existingOwner)) {
                            UserModel newOwner = new UserModel();
                            newOwner.setFirstName(firstName);
                            newOwner.setLastName(lastName);
                            newOwner.setUsername(username);
                            newOwner.setRole(Role.OWNER);
                            newOwner.setStatus(UserStatus.ACTIVE);
                            userRepository.save(newOwner);

                        }
                    }
                    } catch (IOException e) {
                        System.out.println("Error persisting data, error: " + e);
                }


            }

    }
}



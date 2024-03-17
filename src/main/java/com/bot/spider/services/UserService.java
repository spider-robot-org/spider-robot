package com.bot.spider.services;

import com.bot.spider.models.UserModel;
import com.bot.spider.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void save(@Valid UserModel user) {
        userRepository.save(user);
    }

    public void deleteById (Long id) {
        userRepository.deleteById(id);
    }

    public UserModel findUser (String username) {
        return userRepository.findByUsername(username);

    }

    public UserModel findUserById (Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Error to find the following id" + id));
    }

}
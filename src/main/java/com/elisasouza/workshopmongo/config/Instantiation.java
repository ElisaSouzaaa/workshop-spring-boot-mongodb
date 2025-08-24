package com.elisasouza.workshopmongo.config;

import com.elisasouza.workshopmongo.domain.User;
import com.elisasouza.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository  userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        // Garantir ID como String, porque na versão atual do Spring/Mongo, null gera ObjectId
        User maria = new User(UUID.randomUUID().toString(), "Maria Brown", "maria@gmail.com");
        User alex = new User(UUID.randomUUID().toString(), "Alex Green", "alex@gmail.com");
        User bob = new User(UUID.randomUUID().toString(), "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob));
    }
}

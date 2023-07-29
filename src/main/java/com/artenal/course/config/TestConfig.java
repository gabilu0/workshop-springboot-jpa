package com.artenal.course.config;

import com.artenal.course.entities.User;
import com.artenal.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "96966696", "123456");
        User u2 = new User(null, "Ernando Blum", "ernando@gmail.com", "96555588", "188856");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
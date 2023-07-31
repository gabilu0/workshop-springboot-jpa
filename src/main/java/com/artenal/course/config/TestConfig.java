package com.artenal.course.config;

import com.artenal.course.entities.Order;
import com.artenal.course.entities.User;
import com.artenal.course.entities.enums.OrderStatus;
import com.artenal.course.repositories.OrderRepository;
import com.artenal.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "96966696", "123456");
        User u2 = new User(null, "Ernando Blum", "ernando@gmail.com", "96555588", "188856");

        Order o1 = new Order(null, Instant.parse("2023-07-25T19:56:07Z"), u1, OrderStatus.WAITING_PAYMENT);
        Order o2 = new Order(null, Instant.parse("2023-07-27T22:36:57Z"), u2, OrderStatus.PAID);
        Order o3 = new Order(null, Instant.parse("2014-12-12T00:00:00Z"), u1, OrderStatus.PAID);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}

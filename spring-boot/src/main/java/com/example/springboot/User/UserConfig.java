package com.example.springboot.User;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner CommandLineRunner (UserRepo repository) {
        return args -> {
            User yuth = new User("yuth", "panhayuth@gmail.com", "helloworld");
            User reach = new User("reach", "reach@gmail.com", "reachpassword");

            repository.saveAll(List.of(yuth, reach));
        };
    }
}

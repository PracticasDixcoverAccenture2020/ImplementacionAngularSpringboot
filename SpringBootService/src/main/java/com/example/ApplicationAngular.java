package com.example;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.entity.User;
import com.example.respository.UserRepository;

@SpringBootApplication
public class ApplicationAngular {
 
    public static void main(String[] args) {
        SpringApplication.run(ApplicationAngular.class, args);
    }
 
    @Bean
    CommandLineRunner init( UserRepository userRepository) {
        return args -> {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                User user = new User(0,name, name.toLowerCase() + "@domain.com");
                userRepository.save(user);
            });
            userRepository.findAll().forEach(System.out::println);
        };
    }
}
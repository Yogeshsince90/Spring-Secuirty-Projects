package com.yogesh.springsecuritydemo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.yogesh.springsecuritydemo.persistence.InMemoryUserRepository;
import com.yogesh.springsecuritydemo.persistence.UserRepository;
import com.yogesh.springsecuritydemo.web.model.User;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan("com.yogesh.springsecuritydemo.web")
public class SecuringBasicSpringMVCApp {

    @Bean
    public UserRepository userRepository() {
        return new InMemoryUserRepository();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Converter<String, User> messageConverter() {
        return new Converter<String, User>() {
            @Override
            public User convert(String id) {
                return userRepository().findUser(Long.valueOf(id));
            }
        };
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(new Class[] { SecuringBasicSpringMVCApp.class, SecurityConfig.class }, args);
    }

}

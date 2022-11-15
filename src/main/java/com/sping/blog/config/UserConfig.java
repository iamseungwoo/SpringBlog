package com.sping.blog.config;

import com.sping.blog.repository.JpaUserRepository;
import com.sping.blog.repository.UserRepository;
import com.sping.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class UserConfig {
    EntityManager em;

    @Autowired
    public UserConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public UserService userService() {
        return new UserService(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new JpaUserRepository(em);
    }


}

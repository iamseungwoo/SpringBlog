package com.sping.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class BlogConfig {
    EntityManager em;

    @Autowired
    public BlogConfig(EntityManager em) {
        this.em = em;
    }

    
}

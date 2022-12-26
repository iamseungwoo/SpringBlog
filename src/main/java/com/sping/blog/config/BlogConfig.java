package com.sping.blog.config;

import com.sping.blog.repository.Blog.BlogRepository;
import com.sping.blog.repository.Blog.JpaBlogRepository;
import com.sping.blog.service.Blog.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class BlogConfig {
    EntityManager em;

    @Autowired
    public BlogConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public BlogService blogService() {
        return new BlogService(blogRepository());
    }

    @Bean
    public BlogRepository blogRepository() {
        return new JpaBlogRepository(em);
    }
}

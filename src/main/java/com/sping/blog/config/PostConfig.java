package com.sping.blog.config;

import com.sping.blog.repository.Post.JpaPostRepository;
import com.sping.blog.repository.Post.PostRepository;
import com.sping.blog.service.Post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class PostConfig {
    EntityManager em;

    @Autowired
    public PostConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    PostService postService() {
        return new PostService(postRepository());
    }

    @Bean
    PostRepository postRepository() {
        return new JpaPostRepository(em);
    }

}

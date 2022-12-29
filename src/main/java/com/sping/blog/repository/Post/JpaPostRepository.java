package com.sping.blog.repository.Post;

import com.sping.blog.entity.Blog;
import com.sping.blog.entity.Post;

import javax.persistence.EntityManager;

public class JpaPostRepository implements PostRepository{
    EntityManager em;

    public JpaPostRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public void savePost(Post post) {
        em.persist(post);
    }

}

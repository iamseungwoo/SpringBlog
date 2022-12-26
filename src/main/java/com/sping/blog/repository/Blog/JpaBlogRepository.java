package com.sping.blog.repository.Blog;

import com.sping.blog.entity.Blog;

import javax.persistence.EntityManager;

public class JpaBlogRepository implements BlogRepository {
    EntityManager em;

    public JpaBlogRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Blog findBlogByName(String blogName) {
        Blog findBlog = em.createQuery("select b from Blog b where b.blogName = :blogName", Blog.class)
                .setParameter("blogName", blogName).getSingleResult();
        return findBlog;
    }

    @Override
    public Blog createBlog(Blog blog) {
        em.persist(blog);
        return blog;
    }
}

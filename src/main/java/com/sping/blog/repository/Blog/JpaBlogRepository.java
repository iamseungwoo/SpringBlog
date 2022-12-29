package com.sping.blog.repository.Blog;

import com.sping.blog.entity.Blog;
import com.sping.blog.entity.User;

import javax.persistence.EntityManager;
import java.util.List;

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

    @Override
    public Blog findById(Long id) {
        return em.find(Blog.class, id);
    }

    @Override
    public List<Blog> findBlogsByUserPk(Long pk) {
        User findUser = em.find(User.class, pk);
        List<Blog> blogList = em.createQuery("select b from Blog b where b.user = :user", Blog.class)
                .setParameter("user", findUser).getResultList();
        return blogList;
    }
}

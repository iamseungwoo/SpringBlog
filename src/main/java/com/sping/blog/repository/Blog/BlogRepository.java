package com.sping.blog.repository.Blog;

import com.sping.blog.entity.Blog;

import java.util.List;

public interface BlogRepository {
    public Blog findBlogByName(String blogName);
    public Blog createBlog(Blog blog);

    public Blog findById(Long id);
    public List<Blog> findBlogsByUserPk(Long pk);
}

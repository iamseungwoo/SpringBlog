package com.sping.blog.repository.Blog;

import com.sping.blog.entity.Blog;

public interface BlogRepository {
    public Blog findBlogByName(String blogName);
    public Blog createBlog(Blog blog);
}

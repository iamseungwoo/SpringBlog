package com.sping.blog.service.Blog;

import com.sping.blog.repository.Blog.BlogRepository;

import javax.transaction.Transactional;

@Transactional
public class BlogService {
    BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }


}

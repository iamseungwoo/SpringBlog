package com.sping.blog.service.Blog;

import com.sping.blog.entity.Blog;
import com.sping.blog.repository.Blog.BlogRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BlogService {
    BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public void saveBlog(Blog blog) {
        Blog check = blogRepository.createBlog(blog);
        if (check == null) {
            System.out.println("error");
        }
    }

    public List<Blog> findUserBlog(Long userPk) {

    }
}

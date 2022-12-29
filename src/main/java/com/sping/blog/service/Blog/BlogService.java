package com.sping.blog.service.Blog;

import com.sping.blog.dto.Blog.BlogForm;
import com.sping.blog.entity.Blog;
import com.sping.blog.entity.User;
import com.sping.blog.repository.Blog.BlogRepository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Transactional
public class BlogService {
    BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public void saveBlog(User user, BlogForm blogDTO) {
        Blog blog = new Blog();
        blog.setBlogName(blogDTO.getBlogName());
        blog.setUser(user);
        blogRepository.createBlog(blog);
    }

    public Blog getById(Long id) {
        return blogRepository.findById(id);
    }
    public List<Blog> findUserBlog(Long userId) {
        return blogRepository.findBlogsByUserPk(userId);
    }
}

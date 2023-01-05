package com.sping.blog.controller.Blog;

import com.sping.blog.dto.Blog.BlogForm;
import com.sping.blog.entity.Blog;
import com.sping.blog.entity.User;
import com.sping.blog.service.Blog.BlogService;
import com.sping.blog.service.User.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
@Slf4j
public class BlogController {
    BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("")
    public String userBlogPage(Model model) {
        User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("blog", loginUser.getBlog());
        return "/blog/userBlog";
    }

    @GetMapping("/create")
    public String blogForm(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.getBlog() != null)  {
            return "redirect:/";
        }
        return "blog/createBlog";
    }

    @PostMapping("/create")
    public String createBlog(BlogForm blogFormDTO) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        blogService.saveBlog(user, blogFormDTO);
        return "redirect:/";
    }

    @GetMapping("/{blogId}")
    public String blogPage(@PathVariable("blogId") Long blogId, Model model) {
        Blog blog = blogService.getById(blogId);
        model.addAttribute("blog", blog);
        return "blog/detailPage";
    }

    @GetMapping("/delete/{blogId}")
    public String deleteBlog(@PathVariable("blogId") Long blogId) {
        blogService.blogDeleteById(blogId);
        User curUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        curUser.setBlog(null);
        return "redirect:/";
    }
}

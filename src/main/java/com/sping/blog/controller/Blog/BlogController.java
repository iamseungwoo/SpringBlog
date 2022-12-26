package com.sping.blog.controller.Blog;

import com.sping.blog.entity.User;
import com.sping.blog.service.User.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/blog")
@Slf4j
public class BlogController {
    UserService userService;

    public BlogController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String blogUserPage(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("username", ((UserDetails) principal).getUsername());
        return "blog/blogHome";
    }
}

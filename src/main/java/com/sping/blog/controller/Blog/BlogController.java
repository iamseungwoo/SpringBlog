package com.sping.blog.controller.Blog;

import com.sping.blog.entity.User;
import com.sping.blog.service.User.UserService;
import lombok.extern.slf4j.Slf4j;
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

    @GetMapping("/{userEmail}")
    public String blogUserPage(@PathVariable("userEmail") String userEmail, Model model) {
        User blogUser = (User) userService.loadUserByUsername(userEmail);
        model.addAttribute("user", blogUser);
        return "blog/blogHome";
    }
}

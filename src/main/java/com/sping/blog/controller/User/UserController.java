package com.sping.blog.controller.User;

import com.sping.blog.dto.User.UserFormDTO;
import com.sping.blog.entity.User;
import com.sping.blog.service.User.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // all user list get
    @GetMapping("/list")
    public String userList(Model model) {
        List<User> allUser = userService.findAllUser();
        model.addAttribute("userList", allUser);
        return "user";
    }

    // user 회원가입
    @GetMapping("/signUp")
    public String userForm() {
        log.info("hello signup");
        return "sign/signUp";
    }

    @PostMapping("/signUp")
    public String createUser(@ModelAttribute UserFormDTO userFormDTO) {
        log.info("hel");
        userService.joinUser(userFormDTO);
        return "redirect:/user/signIn";
    }

    // user detail
    @GetMapping("/{userid}")
    public String userDetail(@PathVariable("userid") Long userid, Model model) {
        User getUser = userService.getById(userid);
        if (getUser == null) {
            System.out.println("not found");
            return "redirect:/";
        }
        model.addAttribute("user", getUser);
        return "userDetail";
    }

    // user update
    @PostMapping("/{userid}")
    public String userDetail(@PathVariable("userid") Long userid, UserFormDTO userFormDTO) {
        User getUser = userService.getById(userid);
        getUser.setEmail(userFormDTO.getEmail());
        getUser.setPhone(userFormDTO.getPhone());
        getUser.setPassword(userFormDTO.getPassword());
        getUser.setNickname(userFormDTO.getNickname());
        getUser.setName(userFormDTO.getName());

        userService.updateUser(getUser);
        return "redirect:/";
    }

    // user deleted
    @GetMapping("/delete/{userid}")
    public String deleteUser(@PathVariable("userid") Long userid) {
        User user = userService.userDelete(userid);
        if (user == null) {
            System.out.println("error!");
        } else {
            System.out.println("good! delete");
        }
        return "redirect:/";
    }

    @GetMapping("/signIn")
    public String sigInUser() {
        return "/sign/sign_in";
    }


    @GetMapping("/user_access")
    public String userAccess() {
        return "/sign/user_access";
    }

    @GetMapping("/access_denied")
    public String accessDenied() {
        return "/sign/access_denied";
    }

    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated()) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }
}

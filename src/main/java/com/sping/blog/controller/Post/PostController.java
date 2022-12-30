package com.sping.blog.controller.Post;

import com.sping.blog.dto.Post.PostForm;
import com.sping.blog.service.Post.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posts")
@Slf4j
public class PostController {

    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{blogId}")
    public String postFormPage(@PathVariable("blogId") Long blogId) {
        return "posts/createForm";
    }

    @PostMapping("/{blogId}")
    public String postCreate(@PathVariable("blogId") Long blogId, PostForm postForm) {
        postService.createPost(blogId, postForm);
        return "redirect:/blog/" + blogId;
    }

    @GetMapping("/{blogId}/delete/{postId}")
    public String postDelete(@PathVariable("postId") Long postId, @PathVariable("blogId") Long blogId) {
        return "redirect:/blog/" + blogId;
    }
}

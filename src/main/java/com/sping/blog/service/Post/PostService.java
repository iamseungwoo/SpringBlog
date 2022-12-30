package com.sping.blog.service.Post;

import com.sping.blog.dto.Post.PostForm;
import com.sping.blog.entity.Blog;
import com.sping.blog.entity.Post;
import com.sping.blog.repository.Post.PostRepository;
import com.sping.blog.service.Blog.BlogService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

@Transactional
public class PostService {

    @Autowired BlogService blogService;

    PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void createPost(Long blogId, PostForm postForm) {
        Post post = new Post();
        Blog blog = blogService.getById(blogId);

        post.setTitle(postForm.getTitle());
        post.setText(postForm.getText());
        post.setBlog(blog);
        post.getBlog().addPost(post);
        postRepository.savePost(post);
    }

    public Post getPost(Long postId) {
        return postRepository.getPostById(postId);
    }
}

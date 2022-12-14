package com.sping.blog.repository.Post;

import com.sping.blog.entity.Post;

import javax.persistence.EntityManager;

public interface PostRepository {
    public void savePost(Post post);

    Post getPostById(Long postId);

    public void deletePost(Post post);
}

package com.sping.blog.repository.User;

import com.sping.blog.entity.User;

import java.util.List;

public interface UserRepository {
    public List<User> findAll();

    public User save(User user);

    public User findById(Long id);

    public User deleteUser(User user);

    public User findByEmail(String email);
}

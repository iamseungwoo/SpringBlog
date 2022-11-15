package com.sping.blog.repository;


import com.sping.blog.entity.User;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaUserRepository implements UserRepository {
    EntityManager em;

    public JpaUserRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    public List<User> findAll() {
        return em.createQuery("select m from User m", User.class)
                .getResultList();
    }

    @Override
    public User save(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public User findById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public User deleteUser(User user) {
        em.remove(user);
        return user;
    }

    @Override
    public User findByEmail(String email) {
        User user = em.createQuery("select u from User u where u.email = :email", User.class)
                .setParameter("email", email).getSingleResult();
        return user;
    }
}

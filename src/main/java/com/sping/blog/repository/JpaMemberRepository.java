package com.sping.blog.repository;


import com.sping.blog.entity.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {
    EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Member findById(Long id) {
        return em.find(Member.class, id);
    }

    @Override
    public Member deleteMember(Member member) {
        em.remove(member);
        return member;
    }
}

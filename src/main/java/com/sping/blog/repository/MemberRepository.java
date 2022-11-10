package com.sping.blog.repository;

import com.sping.blog.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    public List<Member> findAll();

    public Member save(Member member);

    public Member findById(Long id);

    public Member deleteMember(Member member);
}

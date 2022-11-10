package com.sping.blog.service;

import com.sping.blog.entity.Member;
import com.sping.blog.repository.MemberRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> findAllMember() {
        return memberRepository.findAll();
    }

    public Member joinMember(Member member) {
        memberRepository.save(member);
        return member;
    }

    public Member getById(Long id) {
        return memberRepository.findById(id);
    }

    public Member memberDelete(Long id) {
        Member member = getById(id);
        if (member == null) {
          return null;
        }
        memberRepository.deleteMember(member);
        return member;
    }
}

package com.sping.blog.controller;

import com.sping.blog.dto.MemberFormDTO;
import com.sping.blog.entity.Member;
import com.sping.blog.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MemberController {
    MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    // all member list get
    @GetMapping("/member/list")
    public String memberList(Model model) {
        List<Member> allMember = memberService.findAllMember();
        model.addAttribute("memberList", allMember);
        return "member";
    }
    // member 회원가입
    @GetMapping("/member")
    public String memberForm() {
        return "memberForm";
    }

    @PostMapping("/member")
    public String createMember(@ModelAttribute MemberFormDTO memberFormDTO) {
        Member member = new Member();
        member.setEmail(memberFormDTO.getEmail());
        member.setName(memberFormDTO.getName());
        member.setNickname(memberFormDTO.getNickname());
        member.setPassword(memberFormDTO.getPassword());
        member.setPhone(memberFormDTO.getPhone());

        System.out.println("hello world");
        memberService.joinMember(member);
        return "redirect:/";
    }
    // user detail
    @GetMapping("/member/{userid}")
    public String memberDetail(@PathVariable("userid") Long userid, Model model) {
        Member getMember = memberService.getById(userid);
        if (getMember == null) {
            System.out.println("not found");
            return "redirect:/";
        }
        model.addAttribute("user", getMember);
        return "userDetail";
    }
    // user update
    @PostMapping("/member/{userid}")
    public String memberDetail(@PathVariable("userid") Long userid, MemberFormDTO memberFormDTO) {
        Member getMember = memberService.getById(userid);
        getMember.setEmail(memberFormDTO.getEmail());
        getMember.setPhone(memberFormDTO.getPhone());
        getMember.setPassword(memberFormDTO.getPassword());
        getMember.setNickname(memberFormDTO.getNickname());
        getMember.setName(memberFormDTO.getName());

        memberService.joinMember(getMember);
        return "redirect:/";
    }

    // user delete
    @GetMapping("/member/delete/{userid}")
    public String deleteMember(@PathVariable("userid") Long userid) {
        Member member = memberService.memberDelete(userid);
        if (member == null) {
            System.out.println("error!");
        } else {
            System.out.println("good!");
        }
        return "redirect:/";
    }
}

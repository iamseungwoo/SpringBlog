package com.sping.blog.dto;

import lombok.Getter;

@Getter
public class MemberFormDTO {
    private String name;

    private String phone;
    private String nickname;
    private String password;
    private String email;

    public MemberFormDTO(String name, String phone, String nickname, String password, String email) {
        this.name = name;
        this.phone = phone;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
    }
}

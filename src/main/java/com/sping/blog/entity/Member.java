package com.sping.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter
@Setter
public class Member {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    public Member(){}
    public Member(Long id, String name, String phone, String nickname, String password, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
    }
}

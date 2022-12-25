package com.sping.blog.dto.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignInFormDTO {
    private String email;
    private String password;
}

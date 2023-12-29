package com.std.sbb.domain.member.form;

import com.std.sbb.global.jpa.BaseEntity;

import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberForm {
    @NotEmpty(message = "아이디를 입력해주세요")
    @Size(min = 3, max = 10)
    private String username;
    @NotEmpty(message = "비밀번호를 입력해주세요")
    private String password1;
    @NotEmpty(message = "확인을 위한 비밀번호를 입력해주세요")
    private String password2;
    @NotEmpty(message = "이름을 입력하세요.")
    private String name;
    @NotEmpty(message = "전화번호를 입력해주세요")
    private String phoneNumber;
    @NotEmpty(message = "이메일을 입력하세요.")
    @Email(message = "올바른 이메일 주소를 입력하세요.")
    private String email;
    @NotNull(message = "인증번호를 입력하세요")
    private Integer confirmEmail;
    private String gender;
    private String birthDate;

}

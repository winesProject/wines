package com.std.sbb.domain.member.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberPwForm {
    @NotEmpty(message = "기존 비밀번호를 입력하세요.")
    private String password;
    @NotEmpty(message = "새로운 비밀번호를 입력하세요")
    private String newPassword;
    @NotEmpty(message = "비밀번호를 한번 더 입력하세요.")
    private String passwordConfirm;
}

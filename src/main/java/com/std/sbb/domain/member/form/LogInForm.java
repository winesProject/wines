package com.std.sbb.domain.member.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogInForm {
    @NotEmpty(message = "ID를 입력해주세요")
    private String username;
    @NotEmpty(message = "비밀번호를 입력해주세요")
    private String password;
}

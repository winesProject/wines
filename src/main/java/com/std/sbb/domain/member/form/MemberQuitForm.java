package com.std.sbb.domain.member.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberQuitForm {
    @NotEmpty(message = "비밀번호를 입력하세요")
    private String password;
}

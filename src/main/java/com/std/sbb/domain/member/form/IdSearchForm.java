package com.std.sbb.domain.member.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IdSearchForm {
    @NotEmpty(message = "이름을 입력하세요.")
    private String name;
    @NotEmpty(message = "올바른 이메일 주소를 입력하세요.")
    @Email(message = "올바른 이메일 주소를 입력하세요.")
    private String email;
}

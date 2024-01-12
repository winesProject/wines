package com.std.sbb.domain.member.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class MemberDetailForm {
    @NotEmpty(message = "이름을 입력하세요.")
    private String name;
    @NotEmpty(message = "전화번호를 입력해주세요")
    private String phoneNumber;
    @NotEmpty(message = "이메일을 입력하세요.")
    @Email(message = "올바른 이메일 주소를 입력하세요.")
    private String email;
}

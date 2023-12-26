package com.std.sbb.domain.member.form;

import com.std.sbb.global.jpa.BaseEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberForm extends BaseEntity {
    @Size(min = 3, max = 10)
    private String username;

    private String password1;

    private String password2;
    @NotEmpty(message = "이름을 입력하세요.")
    private String name;

    private String phoneNumber;
    @NotEmpty(message = "이메일을 입력하세요.")
    @Email(message = "올바른 이메일 주소를 입력하세요.")
    private String email;

    private String gender;

    private String birthDate;
}

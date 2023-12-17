package com.std.sbb.domain.member.form;

import com.std.sbb.global.jpa.BaseEntity;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class MemberForm extends BaseEntity {
    @Size(min = 3, max = 10)
    private String nickname;

    private String password1;

    private String password2;

    private String username;

    private String phoneNumber;

    private String email;

    private String gender;

    private String birthDate;
}

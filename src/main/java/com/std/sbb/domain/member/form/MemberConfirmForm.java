package com.std.sbb.domain.member.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MemberConfirmForm{
    @NotEmpty(message = "올바른 유저이름을 입력해주세요")
    private String username;
}
package com.std.sbb.domain.member.service;

import com.std.sbb.domain.member.entity.Member;
import com.std.sbb.domain.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member join(String nickname, String password, String username, String phoneNumber , String email , String gender , String birthDate , String profileImgUrl) {

        Member member = Member
                .builder()
                .nickname(nickname)
                .password(passwordEncoder.encode(password))
                .username(username)
                .phoneNumber(phoneNumber)
                .email(email)
                .gender(gender)
                .birthDate(birthDate)
                .profileImgUrl(profileImgUrl)
                .build();

        return memberRepository.save(member);
    }
    /** 이메일이 존재하는지 확인 **/
    public boolean checkEmail(String memberEmail) {

        /* 이메일이 존재하면 true, 이메일이 없으면 false  */
        return memberRepository.existsByEmail(memberEmail);
    }

    public String getTmpPassword() {
        char[] charSet = new char[]{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        String pwd = "";

        /* 문자 배열 길이의 값을 랜덤으로 10개를 뽑아 조합 */
        int idx = 0;
        for(int i = 0; i < 10; i++){
            idx = (int) (charSet.length * Math.random());
            pwd += charSet[idx];
        }

        return pwd;
    }

    /** 임시 비밀번호로 업데이트 **/
    public void updatePassword(String tmpPassword, String memberEmail) {

        String encryptPassword = passwordEncoder.encode(tmpPassword);
        Member member = memberRepository.findByEmail(memberEmail).orElseThrow(() ->
                new IllegalArgumentException("해당 사용자가 존재하지 않습니다."));

        member.updatePassword(encryptPassword);
    }

    private Optional<Member> findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    @Transactional
    public Member whenSocialLogin(String providerTypeCode, String username, String nickname , String profileImgUrl) {
        Optional<Member> opMember = findByUsername(username);

        if (opMember.isPresent()) return opMember.get();

        // 소셜 로그인를 통한 가입시 비번은 없다.
        return join(username, "", nickname , null , null, null, null , profileImgUrl); // 최초 로그인 시 딱 한번 실행
    }

    public Optional<Member> findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }


}

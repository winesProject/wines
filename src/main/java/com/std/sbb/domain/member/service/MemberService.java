package com.std.sbb.domain.member.service;

import com.std.sbb.domain.member.entity.Member;
import com.std.sbb.domain.member.repository.MemberRepository;
import com.std.sbb.domain.wine.entity.Wine;
import com.std.sbb.domain.wine.repository.WineRepository;
import com.std.sbb.global.security.UserSecurityService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final WineRepository wineRepository;
    private final HttpServletRequest request;

    public Member join(String username, String password, String name, String phoneNumber, String email, String gender, String birthDate, String profileImgUrl) {
        Member member = Member
                .builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .name(name)
                .phoneNumber(phoneNumber)
                .email(email)
                .gender(gender)
                .birthDate(birthDate)
                .profileImgUrl(profileImgUrl)
                .build();
        return memberRepository.save(member);
    }

    public Member modify(Member member, String username, String password, String name, String phoneNumber, String email) {
        member.setUsername(username);
        member.setName(name);
        member.setPassword(passwordEncoder.encode(password));
        member.setPhoneNumber(phoneNumber);
        member.setEmail(email);
        member.setModifyDate(LocalDateTime.now());
        return memberRepository.save(member);
    }


    public boolean checkEmail(String memberEmail) {

        /* 이메일이 존재하면 true, 이메일이 없으면 false  */
        return memberRepository.existsByEmail(memberEmail);
    }

    public String getTmpPassword() {
        char[] charSet = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        String pwd = "";

        /* 문자 배열 길이의 값을 랜덤으로 10개를 뽑아 조합 */
        int idx = 0;
        for (int i = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            pwd += charSet[idx];
        }

        return pwd;
    }

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
    public Member whenSocialLogin(String providerTypeCode, String name, String username, String profileImgUrl) {
        Optional<Member> opMember = findByUsername(username);

        if (opMember.isPresent()) return opMember.get();

        // 소셜 로그인를 통한 가입시 비번은 없다.
        return join(name, "", username, null, null, null, null, profileImgUrl); // 최초 로그인 시 딱 한번 실행
    }

    public Optional<Member> findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }

    public Member getMember(String username) {
        Optional<Member> member = this.memberRepository.findByUsername(username);

        if (member.isPresent()) {
            return member.get();
        } else {
            throw new RuntimeException("회원 정보가 존재하지 않습니다.");
        }
        return member.get();
    }

    public boolean toggleHeart(Long id, String username) {
        Optional<Member> memberOptional = findByUsername(username);
        Optional<Wine> wineOptional = wineRepository.findById(id);

        Member member = memberOptional.get();
        Wine wine = wineOptional.get();

        boolean isLiked = wine.getMember().contains(member);

        if (isLiked) {
            wine.getMember().remove(member);
        } else {
            wine.getMember().add(member);
        }
        wineRepository.save(wine);

        return !isLiked;
    }

    public String getUsernameByNameAndEmail(String name, String email) {
        Member member = memberRepository.findByNameAndEmail(name, email);
        return (member != null) ? member.getUsername() : null;
    }

    public boolean memberEmailCheck(String username, String email) {

        Member member = memberRepository.findByUsernameAndEmail(username, email);
        if (member != null && member.getUsername().equals(username)) {
            return true;
        } else {
            return false;
        }
    }
}
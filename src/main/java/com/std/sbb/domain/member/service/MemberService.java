package com.std.sbb.domain.member.service;

import com.std.sbb.domain.member.entity.Member;
import com.std.sbb.domain.member.repository.MemberRepository;
import com.std.sbb.domain.wine.entity.Wine;
import com.std.sbb.domain.wine.repository.WineRepository;
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
    private final WineRepository wineRepository;

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

    public boolean memberEmailCheck(String username, String Email) {

        Member member = memberRepository.findByEmail(Email);
        if (member != null && member.getName().equals(username)) {
            return true;
        } else {
            return false;
        }
    }

}
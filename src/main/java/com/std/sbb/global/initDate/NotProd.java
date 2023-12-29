package com.std.sbb.global.initDate;

import com.std.sbb.domain.member.service.MemberService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.stream.IntStream;

@Configuration
@Profile("!prod")
public class NotProd {
//    @Value("${spring.security.oauth2.client.registration.kakao.client-id}")
    private String kakaoClientId;
//    @Value("${custom.security.oauth2.client.registration.kakao.devUser.oauthId}")
    private String kakaoDevUserOAuthId;
//    @Value("${custom.security.oauth2.client.registration.kakao.devUser.profileImgUrl}")
    private String kakaoDevUserImageUri;
//    @Value("${custom.security.oauth2.client.registration.kakao.devUser.nickname}")
    private String kakaoDevUserClientName;
    private String googleDevUserOAuthId;
    private String googleDevUserImageUri;
    private String googleDevUserClientName;
    private String naverDevUserOAuthId;
    private String naverDevUserImageUri;
    private String naverDevUserClientName;
    @Bean
    public ApplicationRunner init(MemberService memberService) {
        return args -> {
//            memberService.join("admin", "1234", "관리자", null , "admin@test.com", null,null, null);
//            memberService.join("test1", "1234", "테스트1", null, "test1@test.com", null , null, null );
//            memberService.join("ckh", "1234", "경현", null, null, "남자" , null, null );
//            IntStream.rangeClosed(1, 3).forEach(i -> {
//                memberService.join("user" + i, "1234", "nickname" + i, null , null, null , "user" + i + "@test.com", "");
//            });

            memberService.whenSocialLogin(
                    "KAKAO",
                    kakaoDevUserOAuthId,
                    kakaoDevUserImageUri,
                    kakaoDevUserClientName
            );
            memberService.whenSocialLogin(
                    "GOOGLE",
                    googleDevUserOAuthId,
                    googleDevUserImageUri,
                    googleDevUserClientName
            );
            memberService.whenSocialLogin(
              "NAVER",
                    naverDevUserOAuthId,
                    naverDevUserImageUri,
                    naverDevUserClientName
            );
        };
    }
}


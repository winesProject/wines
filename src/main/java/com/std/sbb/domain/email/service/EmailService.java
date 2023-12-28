package com.std.sbb.domain.email.service;

import com.std.sbb.domain.member.entity.Member;
import com.std.sbb.domain.member.repository.MemberRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;
    private static final String senderEmail = "gusrudchl12@gmail.com";
    private static int number;

    private final PasswordEncoder passwordEncoder;

    private final MemberRepository memberRepository;

    public static void createNumber(){
        //(int) Math.random() * (최댓값-최소값+1) + 최소값
        number = (int)(Math.random() * (90000)) + 10000;
    }

    public MimeMessage createEmail(String email){
        createNumber();
        MimeMessage message = mailSender.createMimeMessage();

        try {
            message.setFrom(senderEmail);
            message.setRecipients(MimeMessage.RecipientType.TO, email);
            message.setSubject("이메일 인증");
            String body = "";
            body += "<h3>" + "요청하신 인증 번호입니다." + "</h3>";
            body += "<h1>" + number + "</h1>";
            body += "<h3>" + "감사합니다." + "</h3>";
            message.setText(body,"UTF-8", "html");
        } catch (MessagingException e){
            throw new RuntimeException(e);
        }
        return message;
    }

    public int sendEmail(String email){
        MimeMessage message = createEmail(email);
        mailSender.send(message);

        return number;
    }

    public void send(String to, String subject, String body) {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
            mimeMessageHelper.setTo(to); // 메일 수신자
            mimeMessageHelper.setSubject(subject); // 메일 제목
            mimeMessageHelper.setText(body, true); // 메일 본문 내용, HTML 여부
            mailSender.send(mimeMessage); // 메일발송
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void createMailAndChangePassword(String email){
        Member member = memberRepository.findByEmail(email);

        if (member == null) {
            throw new UsernameNotFoundException("이메일로 사용자를 찾을 수 없습니다: " + email);
        }

        MimeMessage message = mailSender.createMimeMessage();
        String tempPassword = getTempPassword();

        try {
            message.setFrom(senderEmail);
            message.setRecipients(MimeMessage.RecipientType.TO, email);
            message.setSubject("임시 비밀번호 발송");
            String body = "";
            body += "<h3>" + "임시 비밀번호 입니다." + "</h3>";
            body += "<h1>" + tempPassword + "</h1>";
            body += "<h3>" + "감사합니다." + "</h3>";
            message.setText(body,"UTF-8", "html");

            updatePassword(tempPassword, email);
        } catch (MessagingException e){
            throw new RuntimeException(e);
        }
        mailSender.send(message);
    }

    public void updatePassword(String str,String email){
        Member member = memberRepository.findByEmail(email);

        if (member != null) {
            // 새로운 비밀번호를 암호화
            String encodedPassword = passwordEncoder.encode(str);

            // 암호화된 비밀번호와 사용자 ID를 사용하여 업데이트
            member.setPassword(encodedPassword);
            memberRepository.save(member);
        }
    }

    public String getTempPassword(){
        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        String str = "";

        int idx = 0;
        for (int i = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            str += charSet[idx];
        }
        return str;
    }
}
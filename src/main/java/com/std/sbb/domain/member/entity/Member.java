package com.std.sbb.domain.member.entity;

import com.std.sbb.domain.like.entity.Like;
import com.std.sbb.domain.question.entity.Question;
import com.std.sbb.domain.review.entity.Review;
import com.std.sbb.domain.favorites.entity.Favorites;
import com.std.sbb.global.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Data
@EntityListeners(AuditingEntityListener.class)
public class Member extends BaseEntity {

    public void updatePassword(String password){
        this.password = password;
    }

    private String username;

    private String password;

    @Column(unique = true)
    private String nickname;

    @Column(unique = true)
    private String email;

    private String phoneNumber;

    private String birthDate;

    private String gender;

    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime modifyDate;

    private String profileImgUrl;


    public List<? extends GrantedAuthority> getGrantedAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        grantedAuthorities.add(new SimpleGrantedAuthority("member"));

        if (isAdmin()) {
            grantedAuthorities.add(new SimpleGrantedAuthority("admin"));
        }
        return grantedAuthorities;
    }

    public boolean isAdmin() {
        return "admin".equals(username);
    }
    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Favorites> favorites;
    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Like> likes;
    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Review> review;
    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Question> question;
}
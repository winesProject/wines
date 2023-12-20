package com.std.sbb.domain.member.repository;

import com.std.sbb.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findBynickname(String nickname);

    Optional<Member> findByEmail(String email);

    boolean existsByEmail(String memberEmail);
}

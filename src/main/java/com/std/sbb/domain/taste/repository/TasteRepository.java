package com.std.sbb.domain.taste.repository;

import com.std.sbb.domain.taste.entity.Taste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasteRepository extends JpaRepository<Taste, Long> {
}

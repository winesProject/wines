package com.std.sbb.domain.wine.repository;

import com.std.sbb.domain.wine.entity.Wine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface WineRepository extends JpaRepository<Wine, Long> {
}

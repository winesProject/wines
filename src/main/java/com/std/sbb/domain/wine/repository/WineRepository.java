package com.std.sbb.domain.wine.repository;

import com.std.sbb.domain.wine.entity.Wine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WineRepository extends JpaRepository<Wine, Long> {

}

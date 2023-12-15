package com.std.sbb.domain.select.repository;

import com.std.sbb.domain.select.entity.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelectRepository extends JpaRepository<Select, Long> {
}

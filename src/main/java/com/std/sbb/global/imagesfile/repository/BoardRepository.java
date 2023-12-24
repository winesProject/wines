package com.std.sbb.global.imagesfile.repository;

import com.std.sbb.global.imagesfile.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

}

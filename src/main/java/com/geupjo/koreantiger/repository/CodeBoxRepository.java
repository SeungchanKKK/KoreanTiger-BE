package com.geupjo.koreantiger.repository;

import com.geupjo.koreantiger.entity.CodeBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodeBoxRepository extends JpaRepository<CodeBox, Long> {
    List<CodeBox> findAllByMemberId(Long id);
}

package com.geupjo.koreantiger.repository;

import com.geupjo.koreantiger.entity.CodeBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeBoxRepository extends JpaRepository<CodeBox, Long> {
}

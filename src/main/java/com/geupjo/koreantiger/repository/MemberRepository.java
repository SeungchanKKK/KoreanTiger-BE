package com.geupjo.koreantiger.repository;

import com.geupjo.koreantiger.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}

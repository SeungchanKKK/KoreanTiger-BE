package com.geupjo.koreantiger.repository;

import com.geupjo.koreantiger.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByIdIn(List<Long> memberId);
}

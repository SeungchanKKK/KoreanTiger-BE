package com.geupjo.koreantiger.repository;

import com.geupjo.koreantiger.entity.DetailedAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface DetailedAnalysisRepository extends JpaRepository<DetailedAnalysis, Long> {
    Optional<DetailedAnalysis> findByMemberId(Long memberId);

    List<DetailedAnalysis> findByMemberIdIn(Set<Long> myStudentIds);
}

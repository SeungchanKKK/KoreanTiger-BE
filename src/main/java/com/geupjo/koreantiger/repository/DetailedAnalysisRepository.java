package com.geupjo.koreantiger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailedAnalysisRepository extends JpaRepository<DetailedAnalysisRepository, Long> {
}

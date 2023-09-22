package com.geupjo.koreantiger.repository;

import com.geupjo.koreantiger.entity.EducationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface EducationHistoryRepository extends JpaRepository<EducationHistory, Long> {
    List<EducationHistory> findByMemberIdAndCreatedAtBetween(Long id, LocalDateTime oneYearBeforeToday, LocalDateTime today);
    Optional<EducationHistory> findFirstByMemberIdAndAttendanceIsFalseOrderByCreatedAt(Long id);
}

package com.geupjo.koreantiger.repository;

import com.geupjo.koreantiger.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Long> {

    List<Lecture> findByMemberIdAndCreatedAtBetween(Long id, LocalDateTime oneYearBeforeToday, LocalDateTime today);
}

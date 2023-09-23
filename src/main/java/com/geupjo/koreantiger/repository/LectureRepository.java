package com.geupjo.koreantiger.repository;

import com.geupjo.koreantiger.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
    List<Lecture> findByMemberIdAndCreatedAtBetween(Long memberId, LocalDateTime start, LocalDateTime end);

    Optional<Lecture> findFirstByMemberIdOrderByLastModifiedAt(Long id);
}

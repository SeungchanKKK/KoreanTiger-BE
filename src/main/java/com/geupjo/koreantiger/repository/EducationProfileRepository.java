package com.geupjo.koreantiger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationProfileRepository extends JpaRepository<EducationProfileRepository, Long> {
}
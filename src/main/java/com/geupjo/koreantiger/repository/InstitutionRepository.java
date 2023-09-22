package com.geupjo.koreantiger.repository;

import com.geupjo.koreantiger.entity.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {
}

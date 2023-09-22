package com.geupjo.koreantiger.repository;

import com.geupjo.koreantiger.entity.EducationProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationProfileRepository extends JpaRepository<EducationProfile, Long> {
}

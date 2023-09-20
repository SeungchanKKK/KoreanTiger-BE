package com.geupjo.koreantiger.repository;

import com.geupjo.koreantiger.entity.EducationHistory;
import com.geupjo.koreantiger.entity.EducationProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface EducationProfileRepository extends JpaRepository<EducationProfile, Long> {
    EducationProfile findByMemberId(Long memberId);
    List<EducationProfile> findTop50ByOrderByLevelExperience();
}

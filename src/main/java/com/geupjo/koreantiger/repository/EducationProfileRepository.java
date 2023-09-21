package com.geupjo.koreantiger.repository;

import com.geupjo.koreantiger.entity.EducationProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EducationProfileRepository extends JpaRepository<EducationProfile, Long> {
    Optional<EducationProfile> findByMemberId(Long memberId);
    List<EducationProfile> findTop50ByOrderByLevelDescExperienceDesc();

    List<EducationProfile> findTop50ByOrderByLevelDescExperienceDescIn(List<Long> memberId);

}

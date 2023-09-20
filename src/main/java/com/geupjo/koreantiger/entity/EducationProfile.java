package com.geupjo.koreantiger.entity;

import com.geupjo.koreantiger.common.jpa.BaseEntity;
import com.geupjo.koreantiger.enums.Level;
import com.geupjo.koreantiger.enums.StudentProfileTitle;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;

@Getter
@Entity
public class EducationProfile extends BaseEntity {
    @Min(0)
    @Max(100)
    @Column(nullable = false)
    private int experience;

    @Column
    @Enumerated(EnumType.STRING)
    private Level level;

    @Column(nullable = false)
    private long memberId;

    @Column(nullable = false)
    private long detailedAnalysisId;

    @Column(nullable = false)
    private String lastEducation;

    @Column(nullable = false)
    private double progress;

    @Column(nullable = false)
    private StudentProfileTitle studentProfileTitle;
}

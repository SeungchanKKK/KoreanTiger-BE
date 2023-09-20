package com.geupjo.koreantiger.entity;

import com.geupjo.koreantiger.common.jpa.BaseEntity;
import com.geupjo.koreantiger.enums.LearningTimeGrade;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Getter
@Entity
public class EducationHistory extends BaseEntity {
    @Column
    private boolean attendance;

    @Column
    private long learningStart;

    @Column
    private long learningStop;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LearningTimeGrade learningTimeGrade;

    @Column(nullable = false)
    long memberId;
}

package com.geupjo.koreantiger.entity;

import com.geupjo.koreantiger.common.jpa.BaseEntity;
import com.geupjo.koreantiger.enums.LearningTimeGrade;
import com.geupjo.koreantiger.util.TimeUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import lombok.Getter;

@Getter
@Entity
public class EducationHistory extends BaseEntity {

    @Column
    private boolean attendance;

    @Min(0)
    @Column
    private long learningStart;

    @Min(0)
    @Column
    private long learningStop;

    @Min(0)
    @Column
    private long totalLearningTime;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LearningTimeGrade learningTimeGrade;

    @Column(nullable = false)
    long memberId;

    public long getTotalLeaningTimeMin() {
        return this.totalLearningTime / 60;
    }

    public int getWeekOfMonth() {
        return TimeUtils.weekOfMonth(this.getCreatedAt());
    }
}

package com.geupjo.koreantiger.dto;

import com.geupjo.koreantiger.entity.EducationHistory;
import com.geupjo.koreantiger.entity.Lecture;

import java.util.List;
import java.util.Objects;

public record WeeklyAchievement(
        long learningTime,
        long lectureCount,
        int weekOfMonth
) {
    public static WeeklyAchievement of(List<EducationHistory> histories, List<Lecture> lectures, Integer weekOfMonth) {
        long totalLearningTimeOfWeek = histories
                .stream()
                .filter(Objects::nonNull)
                .map(EducationHistory::getTotalLeaningTimeMin)
                .reduce(Long::sum)
                .orElse(0L);

        long completedLectureOfWeek = lectures
                .stream()
                .filter(Objects::nonNull)
                .filter(Lecture::isComplete)
                .count();

        return new WeeklyAchievement(totalLearningTimeOfWeek, completedLectureOfWeek, weekOfMonth);
    }
}

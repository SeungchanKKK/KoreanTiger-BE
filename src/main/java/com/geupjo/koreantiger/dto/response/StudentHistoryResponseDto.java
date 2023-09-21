package com.geupjo.koreantiger.dto.response;

import com.geupjo.koreantiger.entity.EducationHistory;
import com.geupjo.koreantiger.entity.Lecture;
import com.geupjo.koreantiger.enums.LearningTimeGrade;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public record StudentHistoryResponseDto(
        List<LearningHistory> learningHistories,
        MetaData meta
) {
    public static StudentHistoryResponseDto of(List<EducationHistory> histories, List<Lecture> lectures) {
        List<LearningHistory> oneYearLearningHistory = histories
                .stream()
                .filter(Objects::nonNull)
                .map(LearningHistory::of)
                .toList();

        MetaData meta = MetaData.of(lectures, histories);

        return new StudentHistoryResponseDto(oneYearLearningHistory, meta);
    }

    public record LearningHistory(
            LocalDate date,
            LearningTimeGrade learningTimeGrade
    ) {
        public static LearningHistory of(EducationHistory history) {
            LocalDate date = history.getCreatedAt().toLocalDate();
            LearningTimeGrade grade = LearningTimeGrade.convert(history.getTotalLeaningTimeMin());

            return new LearningHistory(date, grade);
        }
    }

    private record MetaData(
            long completeLectureCount,
            long totalLearningTime
    ) {
        private static MetaData of(List<Lecture> lectures, List<EducationHistory> histories) {
            long completeLectureCount = lectures
                    .stream()
                    .filter(Objects::nonNull)
                    .filter(Lecture::isComplete)
                    .count();

            long totalLearningTime = histories
                    .stream()
                    .map(EducationHistory::getTotalLeaningTimeMin)
                    .reduce(Long::sum)
                    .orElse(0L);


            return new MetaData(completeLectureCount, totalLearningTime);
        }
    }
}

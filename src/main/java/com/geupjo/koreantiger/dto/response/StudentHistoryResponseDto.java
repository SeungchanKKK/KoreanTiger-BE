package com.geupjo.koreantiger.dto.response;

import com.geupjo.koreantiger.entity.EducationHistory;
import com.geupjo.koreantiger.entity.Lecture;
import com.geupjo.koreantiger.enums.LearningTimeGrade;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public record StudentHistoryResponseDto(
        @Schema(description = "일자별 학습 이력")
        List<LearningHistory> learningHistories,

        @Schema(description = "종합 데이터")
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

    private record LearningHistory(
            @Schema(description = "일자", example = "2023-08-01")
            LocalDate date,

            @Schema(description = "학습시간 등급(NONE(0분) ~ VERY_HIGH(80분 이상))", example = "HIGH")
            LearningTimeGrade learningTimeGrade
    ) {
        private static LearningHistory of(EducationHistory history) {
            LocalDate date = history.getCreatedAt().toLocalDate();
            LearningTimeGrade grade = LearningTimeGrade.convert(history.getTotalLeaningTimeMin());

            return new LearningHistory(date, grade);
        }
    }

    private record MetaData(
            @Schema(description = "완료한 강의 수", example = "10")
            long completeLectureCount,

            @Schema(description = "총 학습시간(분)", example = "100")
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

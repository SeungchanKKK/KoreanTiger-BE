package com.geupjo.koreantiger.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record TotalScoreDto(
        @Schema(description = "해당 학생의 종합점수입니다")
        int totalScore,

        @Schema(description = "같은 반 학생들의 상위 종합점수입니다")
        List<Integer> highScoreList,

        @Schema(description = "같은 반 학생들의 중위 종합점수입니다")
        List<Integer> middleScoreList,

        @Schema(description = "같은 반 학생들의 하위 종합점수입니다")
        List<Integer> lowScoreList
) {
}

package com.geupjo.koreantiger.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;

public record RankingBoardDto(
        @Schema(description = "우리학교랭킹 50위까지")
        ArrayList<StudentRankingDto> SchoolRanking,

        @Schema(description = "전체랭킹 50위까지")
        ArrayList<StudentRankingDto> totalRanking
) {
}

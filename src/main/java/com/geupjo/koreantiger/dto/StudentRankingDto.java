package com.geupjo.koreantiger.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record StudentRankingDto(
        @Schema(description = "랭킹")
        int ranking,

        @Schema(description = "이름")
        String name,

        @Schema(description = "진행도")
        int level,

        @Schema(description = "레벨")
        double progress
) {
}

package com.geupjo.koreantiger.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "학생프로필 출석체크 응답Dto 입니다")
public record StudentCheckInDto(
        @Schema(description = "xx일 연속접속 일자")
        int connection,

        @Schema(description = "xx요일 xx일 ex)FRI-22")
        String date
) {
}

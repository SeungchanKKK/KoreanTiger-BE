package com.geupjo.koreantiger.controller.student;

import com.geupjo.koreantiger.common.ApiResponse;
import com.geupjo.koreantiger.dto.response.BiWeeklyAchievementResponseDto;
import com.geupjo.koreantiger.dto.response.RankingBoardResponseDto;
import com.geupjo.koreantiger.dto.response.StudentHistoryResponseDto;
import com.geupjo.koreantiger.dto.response.StudentProfileResponseDto;
import com.geupjo.koreantiger.facade.StudentLmsFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "StudentLmsController", description = "학생 LMS 창에 들어가는 기능 api입니다")
@RequestMapping("/v1/studentLms")
@RestController
@RequiredArgsConstructor
public class StudentLmsController {

    private final StudentLmsFacade studentLmsFacade;

    @Operation(summary = "학생프로필 api 입니다")
    @GetMapping("/experience")
    public ApiResponse<StudentProfileResponseDto> studentProfileResponse(@Parameter(description = "학생Id") @RequestParam(value = "studentID", required = false) Long studentId) {
        StudentProfileResponseDto response = studentLmsFacade.getStudentProfile(1L);
        return ApiResponse.success(response);
    }

    @Operation(summary = "랭킹보드 api 입니다")
    @GetMapping("/ranking")
    public ApiResponse<RankingBoardResponseDto> studentRankingResponse(@Parameter(description = "학생Id") @RequestParam(value = "studentID", required = false) Long studentId) {
        RankingBoardResponseDto response = studentLmsFacade.getRankingBoard(studentId);
        return ApiResponse.success(response);
    }

    @Operation(summary = "학생의 지난 1년간 학습 이력")
    @GetMapping("/histories")
    public ApiResponse<StudentHistoryResponseDto> studentEducationHistories() {
        StudentHistoryResponseDto response = studentLmsFacade.getStudentEducationHistories();
        return ApiResponse.success(response);
    }

    @Operation(summary = "주간 나의 성취도")
    @GetMapping("/achievement")
    public ApiResponse<BiWeeklyAchievementResponseDto> studentWeeklyAchievement() {
        BiWeeklyAchievementResponseDto response = studentLmsFacade.getWeeklyAchievement();
        return ApiResponse.success(response);
    }
}

package com.geupjo.koreantiger.service.facade;

import com.geupjo.koreantiger.common.ApiResponse;
import com.geupjo.koreantiger.dto.response.RankingBoardDto;
import com.geupjo.koreantiger.dto.response.StudentProfileDto;
import com.geupjo.koreantiger.service.StudentLmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentLmsFacade {

    private final StudentLmsService studentLmsService;
    public ApiResponse<StudentProfileDto> getStudentProfile(Long studentId) {
        StudentProfileDto studentProfileDto = studentLmsService.getStudentProfile(studentId);
        return ApiResponse.success(studentProfileDto);
    }


    public ApiResponse<RankingBoardDto> getRankingBoard(Long studentId) {
        RankingBoardDto rankingBoardDto = studentLmsService.getRankingBoard(studentId);
        return ApiResponse.success(rankingBoardDto);
    }
}

package com.geupjo.koreantiger.service.facade;

import com.geupjo.koreantiger.common.ApiResponse;
import com.geupjo.koreantiger.dto.response.RankingBoardDto;
import com.geupjo.koreantiger.dto.response.StudentHistoryResponseDto;
import com.geupjo.koreantiger.dto.response.StudentProfileDto;
import com.geupjo.koreantiger.entity.Member;
import com.geupjo.koreantiger.service.StudentLmsService;
import com.geupjo.koreantiger.util.ContextUtils;
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

    public StudentHistoryResponseDto getStudentEducationHistories() {
        Member currentStudent = ContextUtils.loadMockStudent();
        return studentLmsService.getStudentEducationHistories(currentStudent);
    }
}

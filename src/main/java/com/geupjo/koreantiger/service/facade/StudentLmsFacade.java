package com.geupjo.koreantiger.service.facade;

import com.geupjo.koreantiger.common.ApiResponse;
import com.geupjo.koreantiger.dto.response.StudentExpProfileDto;
import com.geupjo.koreantiger.dto.response.StudentHistoryResponseDto;
import com.geupjo.koreantiger.entity.Member;
import com.geupjo.koreantiger.service.StudentLmsService;
import com.geupjo.koreantiger.util.ContextUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StudentLmsFacade {

    private final StudentLmsService studentLmsService;

    public ApiResponse getStudentExpProfile(Long studentId) {
        StudentExpProfileDto studentExpProfileDto = studentLmsService.getStudentProfile(studentId);
        return ApiResponse.success(studentExpProfileDto);
    }

    public StudentHistoryResponseDto getStudentEducationHistories() {
        Member currentStudent = ContextUtils.loadMockStudent();
        return studentLmsService.getStudentEducationHistories(currentStudent);
    }
}

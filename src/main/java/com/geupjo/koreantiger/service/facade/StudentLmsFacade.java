package com.geupjo.koreantiger.service.facade;

import com.geupjo.koreantiger.common.ApiResponse;
import com.geupjo.koreantiger.dto.response.StudentExpProfileDto;
import com.geupjo.koreantiger.service.StudentLmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StudentLmsFacade {

    private final StudentLmsService studentLmsService;
    public ApiResponse getStudentExpProfile(Long studentId){
        StudentExpProfileDto studentExpProfileDto = new StudentExpProfileDto();
        return ApiResponse.success(studentExpProfileDto);
    }
}

package com.geupjo.koreantiger.facade;

import com.geupjo.koreantiger.dto.response.RankingBoardResponseDto;
import com.geupjo.koreantiger.dto.response.StudentHistoryResponseDto;
import com.geupjo.koreantiger.dto.response.StudentProfileResponseDto;
import com.geupjo.koreantiger.entity.Member;
import com.geupjo.koreantiger.service.StudentLmsService;
import com.geupjo.koreantiger.util.ContextUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentLmsFacade {

    private final StudentLmsService studentLmsService;

    public StudentProfileResponseDto getStudentProfile(Long studentId) {
        return studentLmsService.getStudentProfile(studentId);
    }

    public RankingBoardResponseDto getRankingBoard(Long studentId) {
        return studentLmsService.getRankingBoard(studentId);
    }

    public StudentHistoryResponseDto getStudentEducationHistories() {
        Member currentStudent = ContextUtils.loadMockStudent();
        return studentLmsService.getStudentEducationHistories(currentStudent);
    }
}

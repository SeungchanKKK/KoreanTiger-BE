package com.geupjo.koreantiger.facade;

import com.geupjo.koreantiger.entity.Member;
import com.geupjo.koreantiger.service.MemberService;
import com.geupjo.koreantiger.service.TeacherLmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeacherLmsFacade {
    private final TeacherLmsService teacherLmsService;
    private final MemberService memberService;

    public String exportReport() {
        Member teacher = getTeacher();
        return teacherLmsService.exportReport(teacher);
    }

    private Member getTeacher() {
        return memberService.getTeacher();
    }
}

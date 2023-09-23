package com.geupjo.koreantiger.facade;

import com.geupjo.koreantiger.dto.response.AreaAnalysisDto;
import com.geupjo.koreantiger.dto.response.TotalScoreResponseDto;
import com.geupjo.koreantiger.entity.Member;
import com.geupjo.koreantiger.service.DetailedLmsService;
import com.geupjo.koreantiger.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DetailedLmsFacade {

    private final DetailedLmsService detailedLmsService;

    private final MemberService memberService;

    public AreaAnalysisDto getAreaAnalysis() {
        Member currentStudent = memberService.findById(268L);
        return detailedLmsService.getAreaAnalysis(currentStudent);
    }

    public TotalScoreResponseDto getTotalScore() {
        Member currentStudent = memberService.findById(268L);
        return detailedLmsService.getTotalScore(currentStudent);
    }
}

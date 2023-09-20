package com.geupjo.koreantiger.service;

import com.geupjo.koreantiger.common.exception.CustomException;
import com.geupjo.koreantiger.common.exception.ErrorCode;
import com.geupjo.koreantiger.dto.response.StudentExpProfileDto;
import com.geupjo.koreantiger.dto.response.StudentRankingDto;
import com.geupjo.koreantiger.entity.EducationProfile;
import com.geupjo.koreantiger.entity.Member;
import com.geupjo.koreantiger.repository.EducationProfileRepository;
import com.geupjo.koreantiger.repository.MemberRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class StudentLmsService {
    private final MemberRepository memberRepository;
    private final EducationProfileRepository educationProfileRepository;

    public StudentExpProfileDto getStudentProfile(Long studentId){
        Member student = memberRepository.findById(studentId).orElseThrow(()-> new CustomException(ErrorCode.NOTMATCH_USER_EXCEPTION));
        EducationProfile profile = educationProfileRepository.findByMemberId(student.getId());
        int connection = 111;
        ArrayList<StudentRankingDto>inSchoolRankingBoard = new ArrayList<>();
        ArrayList<StudentRankingDto>totalRankingBoard = new ArrayList<>();
        return new StudentExpProfileDto(
                student.getName(),
                profile.getExperience(),
                connection,
                profile.getStudentProfileTitle(),
                inSchoolRankingBoard,
                totalRankingBoard);
    }
}

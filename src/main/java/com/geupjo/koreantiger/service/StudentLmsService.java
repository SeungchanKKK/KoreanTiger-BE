package com.geupjo.koreantiger.service;

import com.geupjo.koreantiger.common.exception.CustomException;
import com.geupjo.koreantiger.common.exception.ErrorCode;
import com.geupjo.koreantiger.dto.response.StudentExpProfileDto;
import com.geupjo.koreantiger.dto.response.StudentHistoryResponseDto;
import com.geupjo.koreantiger.dto.response.StudentRankingDto;
import com.geupjo.koreantiger.entity.EducationHistory;
import com.geupjo.koreantiger.entity.EducationProfile;
import com.geupjo.koreantiger.entity.Lecture;
import com.geupjo.koreantiger.entity.Member;
import com.geupjo.koreantiger.repository.EducationHistoryRepository;
import com.geupjo.koreantiger.repository.EducationProfileRepository;
import com.geupjo.koreantiger.repository.LectureRepository;
import com.geupjo.koreantiger.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentLmsService {
    private final MemberRepository memberRepository;
    private final EducationProfileRepository educationProfileRepository;
    private final EducationHistoryRepository educationHistoryRepository;
    private final LectureRepository lectureRepository;

    private static final int ONE_YEAR = 1;

    public StudentExpProfileDto getStudentProfile(Long studentId) {
        Member student = memberRepository.findById(studentId).orElseThrow(() -> new CustomException(ErrorCode.NOTMATCH_USER_EXCEPTION));
        EducationProfile profile = educationProfileRepository.findByMemberId(student.getId());
        int connection = 111;

        //학교랭킹 50위 레벨 및 경험치순으로 정렬
        ArrayList<StudentRankingDto> inSchoolRankingBoard = new ArrayList<>();

        //전체랭킹 50위 레벨 및 경험치순으로 정렬
        ArrayList<StudentRankingDto>totalRankingBoard = new ArrayList<>();
        List<EducationProfile>educationHistories= educationProfileRepository.findTop50ByOrderByLevelExperience();
        int totalRank =1;
        for (EducationProfile eachProfile : educationHistories){
            StudentRankingDto dto = new StudentRankingDto(
                    totalRank,
                    memberRepository.findById(eachProfile.getMemberId()).orElseThrow(()-> new CustomException(ErrorCode.NOTMATCH_USER_EXCEPTION)).getName(),
                    eachProfile.getLevel(),
                    eachProfile.getProgress()
                    );
            totalRankingBoard.add(dto);
            totalRank++;
        }

        return new StudentExpProfileDto(
                student.getName(),
                profile.getExperience(),
                connection,
                profile.getStudentProfileTitle(),
                inSchoolRankingBoard,
                totalRankingBoard);
    }

    public StudentHistoryResponseDto getStudentEducationHistories(Member currentStudent) {
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime oneYearBeforeToday = today.minusYears(ONE_YEAR);

        List<EducationHistory> histories = educationHistoryRepository
                .findByMemberIdAndCreatedAtBetween(currentStudent.getId(), oneYearBeforeToday, today);

        List<Lecture> lectures = lectureRepository
                .findByMemberIdAndCreatedAtBetween(currentStudent.getId(), oneYearBeforeToday, today);

        return StudentHistoryResponseDto.of(histories, lectures);
    }
}

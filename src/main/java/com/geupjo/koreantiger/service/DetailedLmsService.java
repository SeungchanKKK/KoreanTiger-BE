package com.geupjo.koreantiger.service;

import com.geupjo.koreantiger.common.exception.CustomException;
import com.geupjo.koreantiger.common.exception.ErrorCode;
import com.geupjo.koreantiger.dto.response.AreaAnalysisDto;
import com.geupjo.koreantiger.dto.response.TotalScoreResponseDto;
import com.geupjo.koreantiger.entity.DetailedAnalysis;
import com.geupjo.koreantiger.entity.Member;
import com.geupjo.koreantiger.repository.DetailedAnalysisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DetailedLmsService {
    private final DetailedAnalysisRepository detailedAnalysisRepository;

    private final StudentLmsService studentLmsService;

    public AreaAnalysisDto getAreaAnalysis(Member currentStudent) {
        DetailedAnalysis detailedAnalysis = detailedAnalysisRepository.findByMemberId(currentStudent.getId())
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND));
        return new AreaAnalysisDto(detailedAnalysis.getGrammar(),
                detailedAnalysis.getAssignment(),
                detailedAnalysis.getAlgorithm(),
                detailedAnalysis.getRecursive(),
                detailedAnalysis.getString(),
                detailedAnalysis.getTotal());
    }

    public TotalScoreResponseDto getTotalScore(Member currentStudent) {
        DetailedAnalysis detailedAnalysis = detailedAnalysisRepository.findByMemberId(currentStudent.getId())
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND));

        List<Long> classMemberIds = studentLmsService.getClassMemberIds(currentStudent);
        List<DetailedAnalysis> inSchoolProfiles = detailedAnalysisRepository.findAllByMemberIdInOrderByTotalDesc(classMemberIds);
        ArrayList<Integer> high = new ArrayList<>();
        ArrayList<Integer> middle = new ArrayList<>();
        ArrayList<Integer> low = new ArrayList<>();
        setLevel(inSchoolProfiles, high, middle, low);
        return new TotalScoreResponseDto(detailedAnalysis.getTotal(), high, middle, low);
    }

    private void setLevel(List<DetailedAnalysis> educationProfiles, ArrayList<Integer> high, ArrayList<Integer> middle, ArrayList<Integer> low) {
        List<Integer> classTotalScores = educationProfiles
                .stream()
                .filter(Objects::nonNull)
                .map(DetailedAnalysis::getTotal)
                .toList();
        for (int i = 0; i <= classTotalScores.size() / 3 - 1; i++) {
            high.add(classTotalScores.get(i));
        }
        for (int i = classTotalScores.size() / 3; i <= classTotalScores.size() / 3 * 2 - 1; i++) {
            middle.add(classTotalScores.get(i));
        }
        for (int i = classTotalScores.size() / 3 * 2; i < classTotalScores.size(); i++) {
            low.add(classTotalScores.get(i));
        }
    }
}

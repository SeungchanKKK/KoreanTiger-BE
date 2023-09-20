package com.geupjo.koreantiger.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@Builder
@Getter
@RequiredArgsConstructor
public class StudentExpProfileDto {
    private String name;
    private int experience;
    private int connection;
    private String title;
    ArrayList<StudentRankingDto>inSchoolRankingBoard;
    ArrayList<StudentRankingDto>totalRankingBoard;
}

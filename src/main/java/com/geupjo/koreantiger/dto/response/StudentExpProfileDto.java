package com.geupjo.koreantiger.dto.response;

import com.geupjo.koreantiger.enums.StudentProfileTitle;

import java.util.ArrayList;
public record StudentExpProfileDto (
        String name,
        int experience,
        int connection,
        StudentProfileTitle title,
        ArrayList<StudentRankingDto>inSchoolRankingBoard,
        ArrayList<StudentRankingDto>totalRankingBoard)
{ }



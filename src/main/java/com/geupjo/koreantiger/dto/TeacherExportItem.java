package com.geupjo.koreantiger.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.geupjo.koreantiger.entity.ClassInfo;
import com.geupjo.koreantiger.entity.DetailedAnalysis;
import com.geupjo.koreantiger.entity.Member;

import java.util.Arrays;

public record TeacherExportItem(
        @JsonProperty(value = "학생 ID")
        long studentId,

        @JsonProperty(value = "학생 이름")
        String studentName,

        @JsonProperty(value = "반 이름")
        String className,

        @JsonProperty(value = "문법 점수")
        int grammar,

        @JsonProperty(value = "과제 점수")
        int assignment,

        @JsonProperty(value = "알고리즘 점수")
        int algorithm,

        @JsonProperty(value = "재귀 점수")
        int recursive,

        @JsonProperty(value = "문자열 점수")
        int string,

        @JsonProperty(value = "총점")
        int total
) {
    public static final String[] ORDERED_COLUMN_NAME = Arrays.stream(TeacherExportItem.class.getDeclaredFields())
            .filter(field -> field.isAnnotationPresent(JsonProperty.class))
            .map(field -> field.getAnnotation(JsonProperty.class).value())
            .toArray(String[]::new);

    public static TeacherExportItem from(ClassInfo classInfo, Member student, DetailedAnalysis analysis) {
        return new TeacherExportItem(
                student.getId(),
                student.getName(),
                classInfo.getName(),
                analysis.getGrammar(),
                analysis.getAssignment(),
                analysis.getAlgorithm(),
                analysis.getRecursive(),
                analysis.getString(),
                analysis.getTotal()
        );
    }
}

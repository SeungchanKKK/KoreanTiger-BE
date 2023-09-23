package com.geupjo.koreantiger.dto.response;

import com.geupjo.koreantiger.entity.CodeBox;
import com.geupjo.koreantiger.entity.Lecture;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record LearningBoxResponseDto(
        @Schema(description = "마지막 학습 강의명")
        String title,

        @Schema(description = "저장한 코드 목록")
        List<CodeRepo> codeRepos
) {
    public static LearningBoxResponseDto of(Lecture lecture, List<CodeBox> codeBox) {
        List<CodeRepo> codeRepos = codeBox
                .stream()
                .map(CodeRepo::of)
                .toList();

        if (lecture == null) {
            return new LearningBoxResponseDto(null, codeRepos);
        } else {
            return new LearningBoxResponseDto(lecture.getName(), codeRepos);
        }
    }

    private record CodeRepo(
            long id,
            String name,
            String code
    ) {
        public static CodeRepo of(CodeBox codeBox) {
            return new CodeRepo(codeBox.getId(), codeBox.getName(), codeBox.getCode());
        }
    }
}

package com.geupjo.koreantiger.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LearningTimeGrade {
    NONE(0),
    LOW(20),
    MIDDLE(40),
    HIGH(60),
    VERY_HIGH(80);

    private final long value;

    public static LearningTimeGrade convert(long learningTime) {
        if (learningTime == 0) {
            return NONE;
        } else if (learningTime >= 20 && learningTime < 40) {
            return LOW;
        } else if (learningTime >= 40 && learningTime < 60) {
            return MIDDLE;
        } else if (learningTime >= 60 && learningTime < 80) {
            return HIGH;
        } else {
            return VERY_HIGH;
        }
    }
}

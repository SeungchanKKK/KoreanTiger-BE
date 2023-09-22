package com.geupjo.koreantiger.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StudentProfileTitle {

    Beginner("코드입문자"),
    BASIC("코드초보자"),
    MIDDLE("코드중급자"),
    HIGH("코드상급자"),
    PROFESSIONAL("코드의고수"),
    MASTER("코드의달인"),
    PROGRAMMER("프로그래머");

    final private String titleName;
}

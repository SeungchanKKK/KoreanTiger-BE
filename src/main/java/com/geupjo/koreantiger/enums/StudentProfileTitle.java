package com.geupjo.koreantiger.enums;

public enum StudentProfileTitle {
    Beginner("코드입문자"),
    BASIC("코드초보자"),
    MIDDLE("코드중급자"),
    HIGH("코드상급자"),
    PROFESSIONAL("코드의고수"),
    MASTER("코드의달인"),
    PROGRAMMER("프로그래머");

    private String titleName;

    StudentProfileTitle(String titleName){
        this.titleName = titleName;
    }

    public String getTitleName(){
        return titleName;
    }
}

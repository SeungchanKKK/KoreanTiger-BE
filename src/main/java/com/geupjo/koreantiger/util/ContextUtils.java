package com.geupjo.koreantiger.util;

import com.geupjo.koreantiger.entity.Member;

public class ContextUtils {
    public static Member loadMockStudent() {
        return Member.getMockStudent();
    }

    public static Member loadMockTeacher() {
        return Member.getMockTeacher();
    }
}

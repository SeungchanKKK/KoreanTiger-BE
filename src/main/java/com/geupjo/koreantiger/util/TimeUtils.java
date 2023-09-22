package com.geupjo.koreantiger.util;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.WeekFields;

public class TimeUtils {

    // 해당 달의 주차(몇 주 차)
    public static int weekOfMonth(LocalDateTime target) {
        return target.get(WeekFields.ISO.weekOfMonth());
    }

    // 현재 시간 기점으로 이번주 일요일 23:59:59
    public static LocalDateTime thisWeekEnd() {
        return currentLocalDateTime()
                .with(DayOfWeek.SUNDAY)
                .withHour(23)
                .withMinute(59)
                .withSecond(59);
    }

    // 현재 시간 기점으로 지난주 월요일 00:00:00
    public static LocalDateTime lastWeekStart() {
        return currentLocalDateTime()
                .with(DayOfWeek.MONDAY)
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .minusWeeks(1);
    }

    // 현재 시간
    public static LocalDateTime currentLocalDateTime() {
        return LocalDateTime.now();
    }
}

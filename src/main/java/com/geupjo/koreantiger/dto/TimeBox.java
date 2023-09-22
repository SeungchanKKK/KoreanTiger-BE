package com.geupjo.koreantiger.dto;

import com.geupjo.koreantiger.util.TimeUtils;

import java.time.LocalDateTime;

public record TimeBox(
        LocalDateTime lastWeekStart,
        LocalDateTime thisWeekEnd,
        int lastWeekOfMonth,
        int thisWeekOfMonth
) {
    public static TimeBox getItem() {
        LocalDateTime lastWeekStart = TimeUtils.lastWeekStart();
        LocalDateTime thisWeekEnd = TimeUtils.thisWeekEnd();

        int lastWeekOfMonth = TimeUtils.weekOfMonth(lastWeekStart);
        int thisWeekOfMonth = TimeUtils.weekOfMonth(thisWeekEnd);

        return new TimeBox(lastWeekStart, thisWeekEnd, lastWeekOfMonth, thisWeekOfMonth);
    }
}

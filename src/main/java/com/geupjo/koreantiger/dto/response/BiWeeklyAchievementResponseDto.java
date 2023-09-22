package com.geupjo.koreantiger.dto.response;

import com.geupjo.koreantiger.dto.TimeBox;
import com.geupjo.koreantiger.dto.WeeklyAchievement;

import java.time.LocalDate;
import java.util.Map;

public record BiWeeklyAchievementResponseDto(
        AchievementItem lastWeek,
        AchievementItem thisWeek,
        Meta meta

) {
    public static BiWeeklyAchievementResponseDto of(Map<Integer, WeeklyAchievement> weeklyAchievement, TimeBox timeBox) {
        AchievementItem lastWeek = AchievementItem.of(weeklyAchievement.get(timeBox.lastWeekOfMonth()));
        AchievementItem thisWeek = AchievementItem.of(weeklyAchievement.get(timeBox.thisWeekOfMonth()));
        Meta meta = Meta.of(lastWeek, thisWeek);

        return new BiWeeklyAchievementResponseDto(lastWeek, thisWeek, meta);
    }

    private record AchievementItem(
            int weekOfMonth,
            long totalLearningTime,
            long completeLectureCount
    ) {
        private static AchievementItem of(WeeklyAchievement weeklyAchievement) {
            return new AchievementItem(
                    weeklyAchievement.weekOfMonth(),
                    weeklyAchievement.lectureCount(),
                    weeklyAchievement.learningTime()
            );
        }
    }

    private record Meta(
            LocalDate date,
            long achievementRate
    ) {
        private static Meta of(AchievementItem lastWeek, AchievementItem thisWeek) {
            LocalDate date = LocalDate.now();
            long achievementRate = calculateAchievementRate(lastWeek, thisWeek);
            return new Meta(date, achievementRate);
        }

        private static long calculateAchievementRate(AchievementItem lastWeek, AchievementItem thisWeek) {
            if (thisWeek.totalLearningTime == 0) {
                return 0;
            }
            if (lastWeek.totalLearningTime <= thisWeek.totalLearningTime) {
                return 100;
            }
            return thisWeek.totalLearningTime() / lastWeek.totalLearningTime() * 100;
        }
    }
}

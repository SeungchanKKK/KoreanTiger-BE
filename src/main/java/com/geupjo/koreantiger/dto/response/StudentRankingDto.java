package com.geupjo.koreantiger.dto.response;

import com.geupjo.koreantiger.enums.Level;

public record StudentRankingDto(
         int ranking,
         String name,
         Level level,
         double progress
) { }

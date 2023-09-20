package com.geupjo.koreantiger.dto.response;

public record StudentRankingDto(
         int ranking,
         String name,
         int level,
         double progress
) { }

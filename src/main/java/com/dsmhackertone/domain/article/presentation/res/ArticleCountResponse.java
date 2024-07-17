package com.dsmhackertone.domain.article.presentation.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Map;

@Getter
@Builder
@AllArgsConstructor
public class ArticleCountResponse {

    private Long count;
    private String month;

    public ArticleCountResponse(Map<String, Object> map) {
        this.month = Month.of(Math.toIntExact((Long) map.get("month"))).toString();
        this.count = (map.get("count") == null) ? 0 : (Long) map.get("count");
    }
}

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

    private Integer count;
    private String month;

    public ArticleCountResponse(Map<String, Object> map) {
        this.month = Month.of((Integer) map.get("month")).toString();
        this.count = (Integer) map.get("count");
    }
}

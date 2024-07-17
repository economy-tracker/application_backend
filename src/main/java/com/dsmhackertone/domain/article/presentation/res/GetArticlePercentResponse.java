package com.dsmhackertone.domain.article.presentation.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
@AllArgsConstructor
public class GetArticlePercentResponse {

    private String category;
    private Double percent;

    public GetArticlePercentResponse(Map<String, Object> map) {
        this.category = (String) map.get("category");
        this.percent = (Double) map.get("percent");
    }
}

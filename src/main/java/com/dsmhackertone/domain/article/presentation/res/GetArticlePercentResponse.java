package com.dsmhackertone.domain.article.presentation.res;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
public class GetArticlePercentResponse {

    private String category;
    private double percent;

    public GetArticlePercentResponse(Map<String, Object> map) {
        GetArticlePercentResponse.builder()
                .category((String) map.get("category"))
                .percent((Double) map.get("percent"))
                .build();
    }
}

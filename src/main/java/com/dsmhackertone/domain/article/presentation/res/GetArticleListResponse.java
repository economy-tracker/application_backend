package com.dsmhackertone.domain.article.presentation.res;

import com.dsmhackertone.domain.article.domain.Article;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class GetArticleListResponse {

    private Integer currentPage;

    private Integer endPage;

    private List<Article> articles;
}

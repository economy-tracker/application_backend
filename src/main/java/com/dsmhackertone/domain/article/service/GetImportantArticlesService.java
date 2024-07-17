package com.dsmhackertone.domain.article.service;

import com.dsmhackertone.domain.article.domain.Article;
import com.dsmhackertone.domain.article.domain.repository.ArticleRepository;
import com.dsmhackertone.domain.article.presentation.res.GetArticleListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetImportantArticlesService {

    private final ArticleRepository repository;

    @Transactional(readOnly = true)
    public GetArticleListResponse execute() {
        List<Article> articles = repository.findAllOrderByImportant();

        return GetArticleListResponse.builder()
                .articles(articles)
                .build();
    }
}

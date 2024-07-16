package com.dsmhackertone.domain.article.service;

import com.dsmhackertone.domain.article.domain.Article;
import com.dsmhackertone.domain.article.domain.repository.ArticleRepository;
import com.dsmhackertone.domain.article.presentation.req.GetArticleListRequest;
import com.dsmhackertone.domain.article.presentation.res.GetArticleListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetArticleListService {

    private final ArticleRepository repository;

    public GetArticleListResponse execute(GetArticleListRequest request) {
        List<Article> articles = repository.findAll();

        return GetArticleListResponse.builder()
                .articles(articles)
                .build();
    }
}

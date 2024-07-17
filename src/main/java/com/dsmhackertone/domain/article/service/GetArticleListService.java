package com.dsmhackertone.domain.article.service;

import com.dsmhackertone.domain.article.domain.Article;
import com.dsmhackertone.domain.article.domain.repository.ArticleRepository;
import com.dsmhackertone.domain.article.presentation.res.GetArticleListResponse;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetArticleListService {

    private final ArticleRepository repository;

    public GetArticleListResponse execute(Integer page) throws BadRequestException {
        if (page == 0) throw new BadRequestException("페이지 번호가 옳지 않습니다 ; ;");

        List<Article> articles = repository.findAllOrderByPubDate((page - 1) * 10);

        return GetArticleListResponse.builder()
                .articles(articles)
                .currentPage(page)
                .endPage((articles.size() + 9) / 10)
                .build();
    }
}

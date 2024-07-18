package com.dsmhackertone.domain.article.service;

import com.dsmhackertone.domain.article.domain.Article;
import com.dsmhackertone.domain.article.domain.repository.ArticleRepository;
import com.dsmhackertone.domain.article.presentation.res.GetArticlePageListResponse;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetArticleListService {

    private final ArticleRepository repository;

    @Transactional(readOnly = true)
    public GetArticlePageListResponse execute(Integer page, String category) throws BadRequestException {
        if (page == 0) throw new BadRequestException("페이지 번호가 옳지 않습니다");

        List<Article> articles = repository.findAllByCategoryOrderByPubDate(category);

        return GetArticlePageListResponse.builder()
                .articles(articles.stream().skip((page - 1) * 10).limit(10).toList())
                .currentPage(page)
                .endPage((articles.size() + 9) / 10)
                .build();
    }
}

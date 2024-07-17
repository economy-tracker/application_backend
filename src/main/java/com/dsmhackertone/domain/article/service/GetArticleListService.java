package com.dsmhackertone.domain.article.service;

import com.dsmhackertone.domain.article.domain.Article;
import com.dsmhackertone.domain.article.domain.repository.ArticleRepository;
import com.dsmhackertone.domain.article.presentation.res.GetArticleListResponse;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetArticleListService {

    private static final Logger log = LoggerFactory.getLogger(GetArticleListService.class);
    private final ArticleRepository repository;

    @Transactional(readOnly = true)
    public GetArticleListResponse execute(Integer page, String category) throws BadRequestException {
        if (page == 0) throw new BadRequestException("페이지 번호가 옳지 않습니다");

        List<Article> articles = repository.findAllByCategoryOrderByPubDate(category);

        if (articles.isEmpty()) throw new BadRequestException("결과값이 없습니다.");



        return GetArticleListResponse.builder()
                .articles(articles.stream().skip((page - 1) * 10).limit(10).toList())
                .currentPage(page)
                .endPage((articles.size() + 9) / 10)
                .build();
    }
}

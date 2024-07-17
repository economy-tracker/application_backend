package com.dsmhackertone.domain.article.service;

import com.dsmhackertone.domain.article.domain.repository.ArticleRepository;
import com.dsmhackertone.domain.article.presentation.res.ArticleCountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetArticleCountByCategoryService {

    private final ArticleRepository repository;

    public List<ArticleCountResponse> execute(String category) {
        return repository.findAllCountByCategory(category).stream().map(ArticleCountResponse::new).toList();
    }


}

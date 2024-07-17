package com.dsmhackertone.domain.article.service;

import com.dsmhackertone.domain.article.domain.repository.ArticleRepository;
import com.dsmhackertone.domain.article.presentation.res.GetArticlePercentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetArticlePercentService {

    private final ArticleRepository repository;

    @Transactional(readOnly = true)
    public List<GetArticlePercentResponse> execute() {
        return repository.findAllPercentLastMonthGroupByCategory().stream().map(GetArticlePercentResponse::new).toList();
    }
}

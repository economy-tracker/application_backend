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
        List<GetArticlePercentResponse> response = repository.findAllPercentLastMonthGroupByCategory().stream().map(GetArticlePercentResponse::new).toList();
        List<String> topCategory = response.stream().sorted((o1, o2) -> (int) (o2.getPercent() - o1.getPercent())).limit(4).map(GetArticlePercentResponse::getCategory).toList();
        List<GetArticlePercentResponse> result = new java.util.ArrayList<>(response.stream().filter(o1 -> topCategory.contains(o1.getCategory())).toList());
        result.add(new GetArticlePercentResponse("others", response.stream().filter(o1 -> !topCategory.contains(o1.getCategory())).map(GetArticlePercentResponse::getPercent).reduce((double) 0, Double::sum)));
        return result;
    }
}

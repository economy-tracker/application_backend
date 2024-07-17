package com.dsmhackertone.domain.article.service;

import com.dsmhackertone.domain.article.domain.repository.ArticleRepository;
import com.dsmhackertone.domain.article.presentation.res.ArticleCountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetArticleCountByCategoryService {

    private final ArticleRepository repository;

    @Transactional(readOnly = true)
    public List<ArticleCountResponse> execute(String category) {
        List<ArticleCountResponse> response = repository.findAllCountByCategory(category).stream().map(ArticleCountResponse::new).toList();

        List<String> recentMonthes = new ArrayList<>();
        for (int i = 0; i < 6; i++) recentMonthes.add(LocalDate.now().getMonth().minus(i).toString());

        return response.stream().filter(o1 -> recentMonthes.contains(o1.getMonth())).toList();
    }


}

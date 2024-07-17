package com.dsmhackertone.domain.article.presentation;

import com.dsmhackertone.domain.article.presentation.res.ArticleCountResponse;
import com.dsmhackertone.domain.article.presentation.res.GetArticleListResponse;
import com.dsmhackertone.domain.article.presentation.res.GetArticlePageListResponse;
import com.dsmhackertone.domain.article.presentation.res.GetArticlePercentResponse;
import com.dsmhackertone.domain.article.service.GetArticleCountByCategoryService;
import com.dsmhackertone.domain.article.service.GetArticleListService;
import com.dsmhackertone.domain.article.service.GetArticlePercentService;
import com.dsmhackertone.domain.article.service.GetImportantArticlesService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final GetArticleListService getArticleListService;
    private final GetArticlePercentService getArticlePercentService;
    private final GetImportantArticlesService getImportantArticlesService;
    private final GetArticleCountByCategoryService getArticleCountByCategoryService;

    @GetMapping
    public GetArticlePageListResponse getArticle(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "category", defaultValue = "economy") String category
    ) throws BadRequestException {
        return getArticleListService.execute(page, category);
    }

    @GetMapping("/chart")
    public List<GetArticlePercentResponse> getArticlePercent() {
        return getArticlePercentService.execute();
    }

    @GetMapping("/important")
    public GetArticleListResponse getImportantArticles() {
        return getImportantArticlesService.execute();
    }

    @GetMapping("/graph")
    public List<ArticleCountResponse> getArticleCountByCategory(
            @RequestParam("category") String category
    ) {
        return getArticleCountByCategoryService.execute(category);
    }
}

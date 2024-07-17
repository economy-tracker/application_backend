package com.dsmhackertone.domain.article.presentation;

import com.dsmhackertone.domain.article.presentation.res.GetArticleListResponse;
import com.dsmhackertone.domain.article.presentation.res.GetArticlePercentResponse;
import com.dsmhackertone.domain.article.service.GetArticleListService;
import com.dsmhackertone.domain.article.service.GetArticlePercentService;
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

    @GetMapping
    public GetArticleListResponse getArticle(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "category", defaultValue = "economy") String category
    ) throws BadRequestException {
        return getArticleListService.execute(page, category);
    }

    @GetMapping("/chart")
    public List<GetArticlePercentResponse> getArticlePercent() {
        return getArticlePercentService.execute();
    }

}

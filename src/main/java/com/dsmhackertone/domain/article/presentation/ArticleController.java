package com.dsmhackertone.domain.article.presentation;

import com.dsmhackertone.domain.article.presentation.req.GetArticleListRequest;
import com.dsmhackertone.domain.article.presentation.res.GetArticleListResponse;
import com.dsmhackertone.domain.article.service.GetArticleListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final GetArticleListService getArticleListService;

    @GetMapping
    public GetArticleListResponse getArticle(@RequestBody GetArticleListRequest request) {
        return getArticleListService.execute(request);
    }

}

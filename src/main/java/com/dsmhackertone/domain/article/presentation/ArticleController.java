package com.dsmhackertone.domain.article.presentation;

import com.dsmhackertone.domain.article.presentation.req.GetArticleListRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @GetMapping
    public String getArticle(GetArticleListRequest request) {



    }

}

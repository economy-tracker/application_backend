package com.dsmhackertone.domain.article.domain.repository;

import com.dsmhackertone.domain.article.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ArticleRepository extends JpaRepository<Article, UUID> {

    @Query("SELECT a FROM Article a ORDER BY a.pubDate DESC")
    List<Article> findAllOrderByPubDate();
}

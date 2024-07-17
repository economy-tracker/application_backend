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

    @Query( "SELECT a.category, ROUND(COUNT(1) / total.count * 100, 1) " +
            "FROM Article a, (" +
                "SELECT COUNT(1) count " +
                "FROM Article a " +
                "WHERE DATEDIFF(NOW(), a.pubDate) < 30" +
            ") total " +
            "WHERE DATEDIFF(NOW(), a.pubDate) < 30 " +
            "GROUP BY a.category")
    List<Map<String, Object>> findAllPercentLastMonthGroupByCategory();


}

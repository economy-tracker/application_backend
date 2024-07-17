package com.dsmhackertone.domain.article.domain.repository;

import com.dsmhackertone.domain.article.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public interface ArticleRepository extends JpaRepository<Article, UUID> {

    @Query( "SELECT a " +
            "FROM Article a " +
            "WHERE a.category = :category " +
            "ORDER BY a.pubDate DESC")
    List<Article> findAllByCategoryOrderByPubDate(@Param("category") String category);

    @Query( "SELECT a.category category, COUNT(*) / CAST(total.count AS double) * 100 percent " +
            "FROM Article a, (" +
                "SELECT COUNT(1) count " +
                "FROM Article a " +
                "WHERE DATEDIFF(NOW(), a.pubDate) < 30" +
            ") total " +
            "WHERE DATEDIFF(NOW(), a.pubDate) < 30 " +
            "GROUP BY a.category")
    List<Map<String, Object>> findAllPercentLastMonthGroupByCategory();

    @Query( "SELECT a " +
            "FROM Article a " +
            "WHERE a.important >= 7 " +
            "ORDER BY a.important DESC " +
            "LIMIT 10")
    List<Article> findAllOrderByImportant();


    @Query( value =
            "SELECT MONTH(a.pubDate) month, count(1) count " +
            "FROM Article a " +
            "WHERE DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 6 MONTH), \"%Y-%m\") <= a.pubDate AND " +
                "a.category = :category " +
            "GROUP BY MONTH(a.pubDate)", nativeQuery = true)
    List<Map<String, Object>> findAllCountByCategory(@Param("category") String category);
}

package com.dsmhackertone.domain.article.domain;

import com.dsmhackertone.global.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Article extends BaseEntity {

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String description;

    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    private String category;

    @Column(columnDefinition = "DATE", nullable = false)
    private LocalDate pubDate;

    @Column(columnDefinition = "VARCHAR(100)", nullable = true)
    private String link;

    @JsonIgnore
    @Column(columnDefinition = "INT", nullable = true)
    private Integer important;
}

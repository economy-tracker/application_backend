package com.dsmhackertone.domain.summary.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Summary {

    @Id
    @Column(unique = true, columnDefinition = "DATE", nullable = false)
    private LocalDate day;

    @Column(columnDefinition = "VARCHAR(60)", nullable = false)
    private String phrase;
}

package com.dsmhackertone.domain.summary.domain.repository;

import com.dsmhackertone.domain.summary.domain.Summary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface SummaryRepository extends JpaRepository<Summary, LocalDate> {

    Summary findByDay(LocalDate day);

    @Query( "SELECT s " +
            "FROM Summary s " +
            "ORDER BY s.day DESC " +
            "LIMIT 1")
    Summary findFirst();
}

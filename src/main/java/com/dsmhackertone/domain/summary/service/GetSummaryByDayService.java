package com.dsmhackertone.domain.summary.service;

import com.dsmhackertone.domain.summary.domain.Summary;
import com.dsmhackertone.domain.summary.domain.repository.SummaryRepository;
import com.dsmhackertone.domain.summary.presentation.res.GetSummaryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class GetSummaryByDayService {

    private final SummaryRepository repository;

    public GetSummaryResponse execute(LocalDate day) {
        Summary summary = repository.findByDay(day);

        return GetSummaryResponse.builder()
                .phrase(summary.getPhrase())
                .date(summary.getDay())
                .build();
    }
}

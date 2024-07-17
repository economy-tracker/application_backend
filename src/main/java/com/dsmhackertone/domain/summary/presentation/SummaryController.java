package com.dsmhackertone.domain.summary.presentation;

import com.dsmhackertone.domain.summary.presentation.res.GetSummaryResponse;
import com.dsmhackertone.domain.summary.service.GetSummaryByDayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/summary")
public class SummaryController {

    private final GetSummaryByDayService getSummaryByDayService;

    @GetMapping("/phrase")
    public GetSummaryResponse getTodaySummary(@RequestParam(value = "date", required = false) LocalDate date) {
        return getSummaryByDayService.execute(date);
    }
}

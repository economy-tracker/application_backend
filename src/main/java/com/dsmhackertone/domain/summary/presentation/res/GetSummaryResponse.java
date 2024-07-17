package com.dsmhackertone.domain.summary.presentation.res;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class GetSummaryResponse {

    private String phrase;
    private LocalDate date;
}

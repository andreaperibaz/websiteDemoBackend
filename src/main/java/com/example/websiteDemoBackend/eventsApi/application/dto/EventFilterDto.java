package com.example.websiteDemoBackend.eventsApi.application.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventFilterDto {

    private List<String> eventTypes; 
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Boolean requiresPayment;
    private String query;

}

package com.example.websiteDemoBackend.eventsApi.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    private Long id;
    private String eventCode;
    private String name;
    private String description;
    private String eventTypeCode;
    private OffsetDateTime registrationStartDate;
    private OffsetDateTime registrationEndDate;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private Integer maxParticipants;
    private List<String> requirements;
    private Boolean requiresPayment;
    private BigDecimal price;

    private EventType eventType;
}

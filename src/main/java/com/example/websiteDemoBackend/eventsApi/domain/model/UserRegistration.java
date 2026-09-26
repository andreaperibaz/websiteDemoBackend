package com.example.websiteDemoBackend.eventsApi.domain.model;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistration {
    private Long id;
    private Long userId;
    private Long eventId;
    private OffsetDateTime registrationDate;
}

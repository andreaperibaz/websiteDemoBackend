package com.example.websiteDemoBackend.eventsApi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventType {
    private Long id;
    private String code;
    private String name;
    private String description;

}

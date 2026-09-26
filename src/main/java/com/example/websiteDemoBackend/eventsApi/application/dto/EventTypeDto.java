package com.example.websiteDemoBackend.eventsApi.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventTypeDto {
    private Long id;
    private String code;
    private String name;
    private String description;
}

package com.example.websiteDemoBackend.eventsApi.application.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventListWrapper {
    private int code;
    private List<EventDto> data;

}

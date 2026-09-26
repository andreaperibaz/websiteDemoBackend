package com.example.websiteDemoBackend.eventsApi.domain.port.output;

import java.util.List;

import com.example.openapi.eventsapi.model.EventFilterDto;
import com.example.websiteDemoBackend.eventsApi.domain.model.Event;
import com.example.websiteDemoBackend.eventsApi.domain.model.Workshop;

public interface EventsPortOut {

    List<Workshop> findAllWorkshops();

    List<Event> findAllEvents();

    List<Workshop> findWorkshops(String query);

    List<Event> findEventsByFilters(EventFilterDto filterDto);

}

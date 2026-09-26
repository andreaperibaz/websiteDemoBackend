package com.example.websiteDemoBackend.eventsApi.domain.port.input;

import java.util.List;

import com.example.openapi.eventsapi.model.EventFilterDto;
import com.example.websiteDemoBackend.eventsApi.domain.model.Event;
import com.example.websiteDemoBackend.eventsApi.domain.model.Workshop;

public interface EventsPortIn {

    List<Workshop> getAllWorkshops();

    List<Event> getAllEvents();

    List<Workshop> searchWorkshops(String query);

    List<Event> filterEvents(EventFilterDto filterDto);

}
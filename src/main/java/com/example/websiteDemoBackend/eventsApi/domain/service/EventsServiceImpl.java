package com.example.websiteDemoBackend.eventsApi.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.openapi.eventsapi.model.EventFilterDto;
import com.example.websiteDemoBackend.eventsApi.domain.model.Event;
import com.example.websiteDemoBackend.eventsApi.domain.model.Workshop;
import com.example.websiteDemoBackend.eventsApi.domain.port.input.EventsPortIn;
import com.example.websiteDemoBackend.eventsApi.domain.port.output.EventsPortOut;

@Service
public class EventsServiceImpl implements EventsPortIn {

    private final EventsPortOut eventsPortOut;

    public EventsServiceImpl(EventsPortOut eventsPortOut) {
        this.eventsPortOut = eventsPortOut;
    }

    @Override
    public List<Workshop> getAllWorkshops() {
        return eventsPortOut.findAllWorkshops();
    }

    @Override
    public List<Event> getAllEvents() {
        return eventsPortOut.findAllEvents();
    }

    @Override
    public List<Workshop> searchWorkshops(String query) {
        return eventsPortOut.findWorkshops(query);
    }

    @Override
    public List<Event> filterEvents(EventFilterDto filterDto) {
        return eventsPortOut.findEventsByFilters(filterDto);
    }

}

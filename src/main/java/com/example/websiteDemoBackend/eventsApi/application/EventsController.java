package com.example.websiteDemoBackend.eventsApi.application;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.openapi.eventsapi.api.EventsApi;
import com.example.openapi.eventsapi.model.EventDto;
import com.example.openapi.eventsapi.model.EventFilterDto;
import com.example.openapi.eventsapi.model.EventListWrapper;
import com.example.openapi.eventsapi.model.WorkshopDto;
import com.example.openapi.eventsapi.model.WorkshopListWrapper;
import com.example.websiteDemoBackend.eventsApi.domain.model.Event;
import com.example.websiteDemoBackend.eventsApi.domain.model.Workshop;
import com.example.websiteDemoBackend.eventsApi.domain.port.input.EventsPortIn;

@RestController
public class EventsController implements EventsApi {

    private final EventsPortIn eventsPortIn;
    private final EventsMapper eventsMapper;

    public EventsController(EventsPortIn eventsPortIn, EventsMapper eventsMapper) {
        this.eventsPortIn = eventsPortIn;
        this.eventsMapper = eventsMapper;
    }

    @Override
    public ResponseEntity<WorkshopListWrapper> getWorkshops() {

        List<Workshop> workshops = eventsPortIn.getAllWorkshops();
        List<WorkshopDto> workshopDtos = eventsMapper.toWorkshopDtoList(workshops);

        WorkshopListWrapper wrapper = new WorkshopListWrapper();
        wrapper.setCode(200);
        wrapper.setData(workshopDtos);

        return ResponseEntity.ok(wrapper);
    }

    @Override
    public ResponseEntity<EventListWrapper> getAllEvents() {
        List<Event> events = eventsPortIn.getAllEvents();
        List<EventDto> eventDtos = eventsMapper.toEventDtoList(events);

        EventListWrapper wrapper = new EventListWrapper();
        wrapper.setCode(200);
        wrapper.setData(eventDtos);

        return ResponseEntity.ok(wrapper);
    }

    @Override
    public ResponseEntity<WorkshopListWrapper> searchWorkshops(@RequestParam String query) {
        List<Workshop> workshops = eventsPortIn.searchWorkshops(query);
        List<WorkshopDto> dtos = eventsMapper.toWorkshopDtoList(workshops);

        WorkshopListWrapper wrapper = new WorkshopListWrapper();
        wrapper.setCode(200);
        wrapper.setData(dtos);

        return ResponseEntity.ok(wrapper);
    }

    @Override
    public ResponseEntity<EventListWrapper> filterEvents(@RequestBody EventFilterDto filterDto) {
        List<Event> filteredEvents = eventsPortIn.filterEvents(filterDto);

        EventListWrapper wrapper = new EventListWrapper();
        wrapper.setCode(200);
        wrapper.setData(eventsMapper.toEventDtoList(filteredEvents));

        return ResponseEntity.ok(wrapper);
    }

}

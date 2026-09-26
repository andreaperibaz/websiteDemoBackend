package com.example.websiteDemoBackend.eventsApi.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.ArrayList;

import com.example.openapi.eventsapi.model.EventFilterDto;
import com.example.websiteDemoBackend.eventsApi.domain.model.Event;
import com.example.websiteDemoBackend.eventsApi.domain.model.Workshop;
import com.example.websiteDemoBackend.eventsApi.domain.port.output.EventsPortOut;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class EventsServiceImplTest {

    @Mock
    private EventsPortOut eventsPortOut;

    @InjectMocks
    private EventsServiceImpl eventsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void when_GetAllWorkshops_expects_WorkshopList() {

        // GIVEN
        Workshop workshop = new Workshop();
        workshop.setId(1L);
        workshop.setName("Murakami: Kafka on the Shore Discussion");

        List<Workshop> mockWorkshops = new ArrayList<>();
        mockWorkshops.add(workshop);

        when(eventsPortOut.findAllWorkshops()).thenReturn(mockWorkshops);

        // WHEN
        List<Workshop> result = eventsService.getAllWorkshops();

        // THEN
        assertEquals(1, result.size());
        assertEquals("Murakami: Kafka on the Shore Discussion", result.get(0).getName());
        verify(eventsPortOut, times(1)).findAllWorkshops();
    }

    @Test
    void when_GetAllEvents_expects_EventList() {

        // GIVEN
        Event event = new Event();
        event.setId(10L);
        event.setName("One Piece Reading Marathon");
        event.setDescription("Read and discuss chapters of One Piece by Oda");

        List<Event> mockEvents = new ArrayList<>();
        mockEvents.add(event);

        when(eventsPortOut.findAllEvents()).thenReturn(mockEvents);

        // WHEN
        List<Event> result = eventsService.getAllEvents();

        // THEN
        assertEquals(1, result.size());
        assertEquals("One Piece Reading Marathon", result.get(0).getName());
        verify(eventsPortOut, times(1)).findAllEvents();
    }

    @Test
    void when_SearchWorkshops_expectst_WorkshopList() {

        // GIVEN
        String query = "Murakami";

        Workshop workshop = new Workshop();
        workshop.setId(2L);
        workshop.setName("Murakami: Norwegian Wood Discussion");

        List<Workshop> mockWorkshops = new ArrayList<>();
        mockWorkshops.add(workshop);

        when(eventsPortOut.findWorkshops(query)).thenReturn(mockWorkshops);

        // WHEN
        List<Workshop> result = eventsService.searchWorkshops(query);

        // THEN
        assertEquals(1, result.size());
        assertEquals("Murakami: Norwegian Wood Discussion", result.get(0).getName());
        verify(eventsPortOut, times(1)).findWorkshops(query);
    }

    @Test
    void when_FilterEvents_expects_EventList() {

        // GIVEN
        EventFilterDto filterDto = new EventFilterDto();
        filterDto.setQuery("manga");

        Event event = new Event();
        event.setId(20L);
        event.setName("One Piece Manga Club");
        event.setDescription("Monthly meeting to discuss One Piece chapters");

        List<Event> mockEvents = new ArrayList<>();
        mockEvents.add(event);

        when(eventsPortOut.findEventsByFilters(filterDto)).thenReturn(mockEvents);

        // WHEN
        List<Event> result = eventsService.filterEvents(filterDto);

        // THEN
        assertEquals(1, result.size());
        assertEquals("One Piece Manga Club", result.get(0).getName());
        verify(eventsPortOut, times(1)).findEventsByFilters(filterDto);
    }
}

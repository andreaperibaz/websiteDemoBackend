package com.example.websiteDemoBackend.eventsApi.application;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

import com.example.openapi.eventsapi.model.EventDto;
import com.example.openapi.eventsapi.model.EventFilterDto;
import com.example.openapi.eventsapi.model.EventListWrapper;
import com.example.openapi.eventsapi.model.WorkshopDto;
import com.example.openapi.eventsapi.model.WorkshopListWrapper;

import com.example.websiteDemoBackend.eventsApi.domain.model.Event;
import com.example.websiteDemoBackend.eventsApi.domain.model.Workshop;
import com.example.websiteDemoBackend.eventsApi.domain.port.input.EventsPortIn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

class EventsControllerTest {

    @Mock
    private EventsPortIn eventsPortIn;

    @Mock
    private EventsMapper eventsMapper;

    @InjectMocks
    private EventsController eventsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void when__GetWorkshops_expects_WorkshopListWrapper() {

        // GIVEN
        Workshop workshop = new Workshop();
        workshop.setId(1L);
        workshop.setName("Murakami: Kafka on the Shore Discussion");

        WorkshopDto dto = new WorkshopDto();
        dto.setId(1L);
        dto.setName("Murakami: Kafka on the Shore Discussion");

        when(eventsPortIn.getAllWorkshops()).thenReturn(List.of(workshop));
        when(eventsMapper.toWorkshopDtoList(List.of(workshop))).thenReturn(List.of(dto));

        // WHEN
        ResponseEntity<WorkshopListWrapper> response = eventsController.getWorkshops();
        WorkshopListWrapper body = response.getBody();

        // THEN
        assertNotNull(body);
        assertEquals(200, body.getCode());
        assertFalse(body.getData().isEmpty());
        assertEquals("Murakami: Kafka on the Shore Discussion", body.getData().get(0).getName());
    }

    @Test
    void when__GetAllEvents_expects_EventListWrapper() {

        // GIVEN
        LocalDateTime localDateTime = LocalDateTime.now();
        OffsetDateTime offsetDateTime = localDateTime.atOffset(ZoneOffset.UTC);

        Event event = new Event();
        event.setId(10L);
        event.setName("One Piece Reading Marathon");
        event.setDescription("Read and discuss chapters of One Piece by Oda");
        event.setStartDate(offsetDateTime);
        event.setEndDate(offsetDateTime.plusDays(1));

        EventDto dto = new EventDto();
        dto.setId(10L);
        dto.setName("One Piece Reading Marathon");
        dto.setDescription("Read and discuss chapters of One Piece by Oda");

        when(eventsPortIn.getAllEvents()).thenReturn(List.of(event));
        when(eventsMapper.toEventDtoList(List.of(event))).thenReturn(List.of(dto));

        // WHEN
        ResponseEntity<EventListWrapper> response = eventsController.getAllEvents();
        EventListWrapper body = response.getBody();

        // THEN
        assertNotNull(body);
        assertEquals(200, body.getCode());
        assertFalse(body.getData().isEmpty());
        assertEquals("One Piece Reading Marathon", body.getData().get(0).getName());
    }

    @Test
    void when__SearchWorkshops_expects_WorkshopListWrapper() {

        // GIVEN
        String query = "Murakami";

        Workshop workshop = new Workshop();
        workshop.setId(2L);
        workshop.setName("Murakami: Norwegian Wood Discussion");

        WorkshopDto dto = new WorkshopDto();
        dto.setId(2L);
        dto.setName("Murakami: Norwegian Wood Discussion");

        when(eventsPortIn.searchWorkshops(query)).thenReturn(List.of(workshop));
        when(eventsMapper.toWorkshopDtoList(List.of(workshop))).thenReturn(List.of(dto));

        // WHEN
        ResponseEntity<WorkshopListWrapper> response = eventsController.searchWorkshops(query);
        WorkshopListWrapper body = response.getBody();

        // THEN
        assertNotNull(body);
        assertEquals(200, body.getCode());
        assertFalse(body.getData().isEmpty());
        assertEquals("Murakami: Norwegian Wood Discussion", body.getData().get(0).getName());
    }

    @Test
    void when__FilterEvents_expects_EventListWrapper() {

        // GIVEN
        EventFilterDto filterDto = new EventFilterDto();
        filterDto.setQuery("manga");

        Event event = new Event();
        event.setId(20L);
        event.setName("One Piece Manga Club");
        event.setDescription("Monthly meeting to discuss One Piece chapters");

        EventDto dto = new EventDto();
        dto.setId(20L);
        dto.setName("One Piece Manga Club");
        dto.setDescription("Monthly meeting to discuss One Piece chapters");

        when(eventsPortIn.filterEvents(filterDto)).thenReturn(List.of(event));
        when(eventsMapper.toEventDtoList(List.of(event))).thenReturn(List.of(dto));

        // WHEN
        ResponseEntity<EventListWrapper> response = eventsController.filterEvents(filterDto);
        EventListWrapper body = response.getBody();

        // THEN
        assertNotNull(body);
        assertEquals(200, body.getCode());
        assertFalse(body.getData().isEmpty());
        assertEquals("One Piece Manga Club", body.getData().get(0).getName());
    }
}

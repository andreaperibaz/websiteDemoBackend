package com.example.websiteDemoBackend.eventsApi.application;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import com.example.openapi.eventsapi.model.EventDto;
import com.example.openapi.eventsapi.model.WorkshopDto;
import com.example.websiteDemoBackend.eventsApi.domain.model.Event;
import com.example.websiteDemoBackend.eventsApi.domain.model.EventType;
import com.example.websiteDemoBackend.eventsApi.domain.model.Workshop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventsMapperTest {

    private EventsMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new EventsMapperImpl();
    }

    @Test
    void from_Workshop_to_WorkshopDto() {

        // GIVEN
        Workshop workshop = createWorkshop(1L, "Murakami Reading", createEventType("workshop"));

        // WHEN
        WorkshopDto dto = mapper.toWorkshopDto(workshop);

        // THEN
        assertNotNull(dto);
        assertEquals(1L, dto.getId());
        assertEquals("Murakami Reading", dto.getName());
        assertEquals(WorkshopDto.EventTypeEnum.WORKSHOP, dto.getEventType());
    }

    @Test
    void from_Event_to_EventDto() {
        // GIVEN
        Event event = createEvent(10L, "Book Club Discussion", createEventType("book_club"));

        // WHEN
        EventDto dto = mapper.toEventDto(event);

        // THEN
        assertNotNull(dto);
        assertEquals("Book Club Discussion", dto.getName());
        assertEquals(EventDto.EventTypeEnum.BOOK_CLUB, dto.getEventType());
        assertEquals(
                LocalDateTime.of(2025, 9, 10, 10, 0),
                dto.getStartDate().toLocalDateTime());

    }

    private EventType createEventType(String code) {
        EventType eventType = new EventType();
        eventType.setCode(code);
        return eventType;
    }

    private Workshop createWorkshop(Long id, String name, EventType type) {
        Workshop workshop = new Workshop();
        workshop.setId(id);
        workshop.setName(name);
        workshop.setEventType(type);
        return workshop;
    }

    private Event createEvent(Long id, String name, EventType type) {
        Event event = new Event();
        event.setId(id);
        event.setName(name);
        event.setEventType(type);
        event.setStartDate(OffsetDateTime.of(2025, 9, 10, 10, 0, 0, 0, ZoneOffset.UTC));
        event.setEndDate(OffsetDateTime.of(2025, 9, 10, 12, 0, 0, 0, ZoneOffset.UTC));
        return event;
    }

}

package com.example.websiteDemoBackend.eventsApi.infraestructure;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import com.example.websiteDemoBackend.eventsApi.domain.model.Workshop;
import com.example.websiteDemoBackend.eventsApi.domain.model.Event;
import com.example.websiteDemoBackend.eventsApi.infraestructure.entities.EventEntity;
import com.example.websiteDemoBackend.eventsApi.infraestructure.entities.WorkshopEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventsEntityMapperTest {

    private EventsEntityMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new EventsEntityMapperImpl();
    }

    @Test
    void from_WorkshopEntity_to_Workshop() {
        // GIVEN
        WorkshopEntity entity = createWorkshopEntity(1L, "Murakami Reading");

        // WHEN
        Workshop workshop = mapper.toWorkshop(entity);

        // THEN
        assertNotNull(workshop);
        assertEquals("Murakami Reading", workshop.getName());
        assertEquals("Book Notes", workshop.getMaterials());
        assertEquals(
                entity.getEvent().getStartDate(),
                workshop.getStartDate().toLocalDateTime());
        assertEquals(
                entity.getEvent().getEndDate(),
                workshop.getEndDate().toLocalDateTime());
    }

    @Test
    void from_EventEntity_to_Event() {
        // GIVEN
        EventEntity entity = createEventEntity(10L, "EV-10", "Book Club Discussion");

        // WHEN
        Event event = mapper.toEvent(entity);

        // THEN
        assertNotNull(event);
        assertEquals("Book Club Discussion", event.getName());
        assertEquals("EV-10", event.getEventTypeCode());
        assertEquals(entity.getStartDate(), event.getStartDate().toLocalDateTime());
        assertEquals(entity.getEndDate(), event.getEndDate().toLocalDateTime());
    }

    private EventEntity createEventEntity(Long id, String code, String name) {
        EventEntity eventEntity = new EventEntity();
        eventEntity.setId(id);
        eventEntity.setEventCode(code);
        eventEntity.setName(name);
        eventEntity.setStartDate(LocalDateTime.of(2025, 9, 10, 10, 0));
        eventEntity.setEndDate(LocalDateTime.of(2025, 9, 10, 12, 0));
        return eventEntity;
    }

    private WorkshopEntity createWorkshopEntity(Long id, String name) {
        WorkshopEntity workshopEntity = new WorkshopEntity();
        workshopEntity.setId(id);
        EventEntity event = createEventEntity(id, "W-" + id, name);
        workshopEntity.setEvent(event);
        workshopEntity.setMaterials("Book Notes");
        return workshopEntity;
    }
}

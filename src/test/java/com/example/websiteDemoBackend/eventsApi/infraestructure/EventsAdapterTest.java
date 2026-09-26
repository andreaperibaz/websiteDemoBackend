package com.example.websiteDemoBackend.eventsApi.infraestructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.List;

import com.example.openapi.eventsapi.model.EventFilterDto;
import com.example.websiteDemoBackend.eventsApi.domain.model.Event;
import com.example.websiteDemoBackend.eventsApi.domain.model.Workshop;
import com.example.websiteDemoBackend.eventsApi.infraestructure.entities.EventEntity;
import com.example.websiteDemoBackend.eventsApi.infraestructure.entities.WorkshopEntity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class EventsAdapterTest {

    @Mock
    private WorkshopRepository workshopRepository;

    @Mock
    private EventsRepository eventsRepository;

    @Mock
    private EventsEntityMapper eventsEntityMapper;

    @InjectMocks
    private EventsAdapter eventsAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void when_findAllWorkshops_expects_WorkshopList() {

        // GIVEN
        EventEntity event = new EventEntity();
        event.setId(1L);
        event.setName("Murakami: Kafka on the Shore Discussion");
        event.setDescription("Book club discussion");

        WorkshopEntity workshop = new WorkshopEntity();
        workshop.setId(1L);
        workshop.setEvent(event);
        workshop.setMaterials("Notebook, Pen");

        List<WorkshopEntity> entities = List.of(workshop);

        Workshop domainWorkshop = new Workshop();
        domainWorkshop.setName("Murakami: Kafka on the Shore Discussion");
        List<Workshop> domainList = List.of(domainWorkshop);

        when(workshopRepository.findAll()).thenReturn(entities);
        when(eventsEntityMapper.toWorkshopList(entities)).thenReturn(domainList);

        // WHEN
        List<Workshop> result = eventsAdapter.findAllWorkshops();

        // THEN
        assertEquals(1, result.size());
        assertEquals("Murakami: Kafka on the Shore Discussion", result.get(0).getName());
        verify(workshopRepository, times(1)).findAll();
        verify(eventsEntityMapper, times(1)).toWorkshopList(entities);
    }

    @Test
    void when_FindAllEvents_expects_EventList() {

        // GIVEN
        EventEntity entity = new EventEntity();
        entity.setId(10L);
        entity.setName("One Piece Reading Marathon");
        entity.setDescription("Read and discuss chapters of One Piece by Oda");
        entity.setPrice(BigDecimal.ZERO);

        List<EventEntity> entities = List.of(entity);

        Event domainEvent = new Event();
        domainEvent.setName("One Piece Reading Marathon");
        domainEvent.setDescription("Read and discuss chapters of One Piece by Oda");
        List<Event> domainList = List.of(domainEvent);

        when(eventsRepository.findAll()).thenReturn(entities);
        when(eventsEntityMapper.toEventList(entities)).thenReturn(domainList);

        // WHEN
        List<Event> result = eventsAdapter.findAllEvents();

        // THEN
        assertEquals(1, result.size());
        assertEquals("One Piece Reading Marathon", result.get(0).getName());
        verify(eventsRepository, times(1)).findAll();
        verify(eventsEntityMapper, times(1)).toEventList(entities);
    }

    @Test
    void when_FindEventsByFilters_expects_EventList() {

        // GIVEN
        EventEntity entity = new EventEntity();
        entity.setId(20L);
        entity.setName("Murakami: Norwegian Wood Discussion");
        entity.setDescription("Book club discussion");
        entity.setPrice(BigDecimal.valueOf(20.0));
        entity.setRequiresPayment(false);

        List<EventEntity> entities = List.of(entity);

        Event domainEvent = new Event();
        domainEvent.setName("Murakami: Norwegian Wood Discussion");
        domainEvent.setDescription("Book club discussion");
        List<Event> domainList = List.of(domainEvent);

        when(eventsRepository.findAll()).thenReturn(entities);
        when(eventsEntityMapper.toEventList(entities)).thenReturn(domainList);

        EventFilterDto filterDto = new EventFilterDto();
        filterDto.setMinPrice(10.0);
        filterDto.setMaxPrice(30.0);
        filterDto.setRequiresPayment(false);
        filterDto.setQuery("Murakami");

        // WHEN
        List<Event> result = eventsAdapter.findEventsByFilters(filterDto);

        // THEN
        assertEquals(1, result.size());
        assertEquals("Murakami: Norwegian Wood Discussion", result.get(0).getName());
        verify(eventsRepository, times(1)).findAll();
        verify(eventsEntityMapper, times(1)).toEventList(anyList());
    }
}

package com.example.websiteDemoBackend.eventsApi.infraestructure;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.openapi.eventsapi.model.EventFilterDto;
import com.example.websiteDemoBackend.eventsApi.domain.model.Event;
import com.example.websiteDemoBackend.eventsApi.domain.model.Workshop;
import com.example.websiteDemoBackend.eventsApi.domain.port.output.EventsPortOut;
import com.example.websiteDemoBackend.eventsApi.infraestructure.entities.EventEntity;
import com.example.websiteDemoBackend.eventsApi.infraestructure.entities.WorkshopEntity;

@Component
public class EventsAdapter implements EventsPortOut {

        private final WorkshopRepository workshopRepository;
        private final EventsEntityMapper eventsEntityMapper;
        private final EventsRepository eventsRepository;

        public EventsAdapter(WorkshopRepository workshopRepository, EventsEntityMapper eventsEntityMapper,
                        EventsRepository eventsRepository) {
                this.workshopRepository = workshopRepository;
                this.eventsEntityMapper = eventsEntityMapper;
                this.eventsRepository = eventsRepository;
        }

        @Override
        public List<Workshop> findAllWorkshops() {
                List<WorkshopEntity> entities = workshopRepository.findAll();
                List<Workshop> listWorkshops = eventsEntityMapper.toWorkshopList(entities);
                return listWorkshops;
        }

        @Override
        public List<Event> findAllEvents() {
                List<EventEntity> entities = eventsRepository.findAll();
                List<Event> listEvents = eventsEntityMapper.toEventList(entities);
                return listEvents;
        }

        @Override
        public List<Workshop> findWorkshops(String filters) {
                List<WorkshopEntity> result = new ArrayList<>();

                result.addAll(workshopRepository.findByEvent_NameIgnoreCase(filters));

                result.addAll(workshopRepository.findByEvent_NameContainingIgnoreCase(filters));

                return result.stream()
                                .map(eventsEntityMapper::toWorkshop)
                                .distinct()
                                .toList();

        }

        @Override
        public List<Event> findEventsByFilters(EventFilterDto filterDto) {
                List<EventEntity> entities = eventsRepository.findAll();

                if (filterDto.getEventTypes() != null && !filterDto.getEventTypes().isEmpty()) {
                        entities = entities.stream()
                                        .filter(e -> filterDto.getEventTypes().contains(e.getEventType().getCode()))
                                        .collect(Collectors.toList());
                }

                if (filterDto.getStartDate() != null) {
                        LocalDateTime startDate = filterDto.getStartDate().toLocalDateTime();
                        entities = entities.stream()
                                        .filter(e -> !e.getStartDate().isBefore(startDate))
                                        .collect(Collectors.toList());
                }

                if (filterDto.getEndDate() != null) {
                        LocalDateTime endDate = filterDto.getEndDate().toLocalDateTime();
                        entities = entities.stream()
                                        .filter(e -> !e.getEndDate().isAfter(endDate))
                                        .collect(Collectors.toList());
                }

                if (filterDto.getMinPrice() != null) {
                        BigDecimal minPrice = BigDecimal.valueOf(filterDto.getMinPrice());
                        entities = entities.stream()
                                        .filter(e -> e.getPrice().compareTo(minPrice) >= 0)
                                        .collect(Collectors.toList());
                }
                if (filterDto.getMaxPrice() != null) {
                        BigDecimal maxPrice = BigDecimal.valueOf(filterDto.getMaxPrice());
                        entities = entities.stream()
                                        .filter(e -> e.getPrice().compareTo(maxPrice) <= 0)
                                        .collect(Collectors.toList());
                }

                if (filterDto.getRequiresPayment() != null) {
                        Boolean requiresPayment = filterDto.getRequiresPayment();
                        entities = entities.stream()
                                        .filter(e -> e.getRequiresPayment().equals(requiresPayment))
                                        .collect(Collectors.toList());
                }

                if (filterDto.getQuery() != null && !filterDto.getQuery().isBlank()) {
                        String queryLower = filterDto.getQuery().toLowerCase();
                        entities = entities.stream()
                                        .filter(e -> e.getName().toLowerCase().contains(queryLower) ||
                                                        e.getDescription().toLowerCase().contains(queryLower))
                                        .collect(Collectors.toList());
                }

                return eventsEntityMapper.toEventList(entities);
        }

}

package com.example.websiteDemoBackend.eventsApi.infraestructure;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.websiteDemoBackend.eventsApi.infraestructure.entities.EventEntity;

public interface EventsRepository extends JpaRepository<EventEntity, Long> {

    List<EventEntity> findByEventType_Code(String eventType);

    List<EventEntity> findByStartDateBetween(LocalDateTime start, LocalDateTime end);

    List<EventEntity> findByRequiresPayment(Boolean requiresPayment);

    List<EventEntity> findByPriceLessThanEqual(BigDecimal maxPrice);

}

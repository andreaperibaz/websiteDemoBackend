package com.example.websiteDemoBackend.eventsApi.infraestructure;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.websiteDemoBackend.eventsApi.infraestructure.entities.WorkshopEntity;

public interface WorkshopRepository extends JpaRepository<WorkshopEntity, Long> {

    Optional<WorkshopEntity> findById(Long id);

    List<WorkshopEntity> findByEvent_NameIgnoreCase(String name);

    List<WorkshopEntity> findByEvent_NameContainingIgnoreCase(String name);
}
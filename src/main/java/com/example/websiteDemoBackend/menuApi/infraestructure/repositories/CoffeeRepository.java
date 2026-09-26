package com.example.websiteDemoBackend.menuApi.infraestructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.websiteDemoBackend.menuApi.infraestructure.entities.CoffeeEntity;

public interface CoffeeRepository extends JpaRepository<CoffeeEntity, Long> {
}
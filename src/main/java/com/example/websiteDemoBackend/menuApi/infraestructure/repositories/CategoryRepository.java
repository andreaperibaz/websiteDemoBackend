package com.example.websiteDemoBackend.menuApi.infraestructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.websiteDemoBackend.menuApi.infraestructure.entities.CategoryEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}

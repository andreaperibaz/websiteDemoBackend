package com.example.websiteDemoBackend.usersApi.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.websiteDemoBackend.usersApi.infraestructure.entities.ContactFormEntity;

@Repository
public interface ContactFormRepository extends JpaRepository<ContactFormEntity, Long> {

}

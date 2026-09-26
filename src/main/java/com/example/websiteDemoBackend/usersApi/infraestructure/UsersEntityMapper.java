package com.example.websiteDemoBackend.usersApi.infraestructure;

import org.mapstruct.Mapper;

import com.example.websiteDemoBackend.usersApi.domain.model.ContactForm;
import com.example.websiteDemoBackend.usersApi.infraestructure.entities.ContactFormEntity;

@Mapper(componentModel = "spring")
public interface UsersEntityMapper {

    ContactFormEntity toContactFormEntity(ContactForm contactForm);

    ContactForm toContactForm(ContactFormEntity contactFormEntity);

}

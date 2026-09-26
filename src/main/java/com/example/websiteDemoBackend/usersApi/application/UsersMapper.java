package com.example.websiteDemoBackend.usersApi.application;

import org.mapstruct.Mapper;

import com.example.openapi.usersapi.model.ContactFormDto;
import com.example.websiteDemoBackend.usersApi.domain.model.ContactForm;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    ContactForm toContactForm(ContactFormDto contactFormDto);
}

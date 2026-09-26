package com.example.websiteDemoBackend.usersApi.infraestructure;

import org.springframework.stereotype.Component;

import com.example.websiteDemoBackend.usersApi.domain.model.ContactForm;
import com.example.websiteDemoBackend.usersApi.domain.port.output.UsersPortOut;
import com.example.websiteDemoBackend.usersApi.infraestructure.entities.ContactFormEntity;
import com.example.websiteDemoBackend.usersApi.infraestructure.repository.ContactFormRepository;

@Component
public class UsersAdapter implements UsersPortOut {

    private final ContactFormRepository contactFormRepository;
    private final UsersEntityMapper contactFormEntityMapper;

    public UsersAdapter(ContactFormRepository contactFormRepository, UsersEntityMapper contactFormEntityMapper) {
        this.contactFormRepository = contactFormRepository;
        this.contactFormEntityMapper = contactFormEntityMapper;
    }

    @Override
    public ContactForm saveContactForm(ContactForm contactForm) {

        ContactFormEntity contactFormEntity = contactFormEntityMapper.toContactFormEntity(contactForm);

        ContactFormEntity savedEntity = contactFormRepository.save(contactFormEntity);

        return contactFormEntityMapper.toContactForm(savedEntity);
    }

}

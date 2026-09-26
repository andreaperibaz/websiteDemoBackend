package com.example.websiteDemoBackend.usersApi.domain.port.input;

import com.example.websiteDemoBackend.usersApi.domain.model.ContactForm;

public interface UsersPortIn {

    ContactForm submitContactForm(ContactForm contactForm);
}

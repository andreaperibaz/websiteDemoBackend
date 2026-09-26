package com.example.websiteDemoBackend.usersApi.domain.port.output;

import com.example.websiteDemoBackend.usersApi.domain.model.ContactForm;

public interface UsersPortOut {

    ContactForm saveContactForm(ContactForm contactForm);
}

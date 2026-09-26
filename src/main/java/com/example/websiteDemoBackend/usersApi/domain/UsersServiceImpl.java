package com.example.websiteDemoBackend.usersApi.domain;

import org.springframework.stereotype.Service;

import com.example.websiteDemoBackend.usersApi.domain.model.ContactForm;
import com.example.websiteDemoBackend.usersApi.domain.port.input.UsersPortIn;
import com.example.websiteDemoBackend.usersApi.domain.port.output.UsersPortOut;

@Service
public class UsersServiceImpl implements UsersPortIn {

    private final UsersPortOut usersPortOut;

    public UsersServiceImpl(UsersPortOut usersPortOut) {
        this.usersPortOut = usersPortOut;
    }

    @Override
    public ContactForm submitContactForm(ContactForm contactForm) {
        return usersPortOut.saveContactForm(contactForm);

    }
}

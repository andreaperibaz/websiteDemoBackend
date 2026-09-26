package com.example.websiteDemoBackend.usersApi.application;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.example.openapi.usersapi.api.UsersApi;
import com.example.openapi.usersapi.model.ContactFormDto;
import com.example.openapi.usersapi.model.ContactFormResponse;
import com.example.websiteDemoBackend.usersApi.domain.model.ContactForm;
import com.example.websiteDemoBackend.usersApi.domain.port.input.UsersPortIn;

@RestController
public class UsersController implements UsersApi {

    private final UsersPortIn usersPortIn;
    private final UsersMapper usersMapper;

    public UsersController(UsersPortIn usersPortIn, UsersMapper usersMapper) {
        this.usersPortIn = usersPortIn;
        this.usersMapper = usersMapper;
    }

    @Override
    public ResponseEntity<ContactFormResponse> submitContactForm(ContactFormDto contactFormDto) {

        ContactForm contactForm = usersMapper.toContactForm(contactFormDto);

        usersPortIn.submitContactForm(contactForm);

        ContactFormResponse response = new ContactFormResponse();
        response.setMessage("Your message has been sent successfully.");

        return ResponseEntity.ok(response);
    }
}

package com.example.websiteDemoBackend.usersApi.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.openapi.usersapi.model.ContactFormDto;
import com.example.openapi.usersapi.model.ContactFormResponse;
import com.example.websiteDemoBackend.usersApi.domain.model.ContactForm;
import com.example.websiteDemoBackend.usersApi.domain.port.input.UsersPortIn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class UsersControllerTest {

    @Mock
    private UsersPortIn usersPortIn;

    @Mock
    private UsersMapper usersMapper;

    @InjectMocks
    private UsersController usersController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void when_SubmitContactForm_expect_SuccessResponse() {
        // GIVEN
        ContactFormDto contactFormDto = new ContactFormDto();
        contactFormDto.setName("Test");
        contactFormDto.setEmail("test@example.com");
        contactFormDto.setMessage("Test test test test test!");
        contactFormDto.setMailingList(true);

        ContactForm contactForm = new ContactForm();
        contactForm.setName("Test");
        contactForm.setEmail("test@example.com");
        contactForm.setMessage("Test test test test test!");
        contactForm.setMailingList(true);

        when(usersMapper.toContactForm(contactFormDto)).thenReturn(contactForm);

        // WHEN
        ResponseEntity<ContactFormResponse> response = usersController.submitContactForm(contactFormDto);
        ContactFormResponse body = response.getBody();

        // THEN
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Your message has been sent successfully.", body.getMessage());
        verify(usersPortIn).submitContactForm(contactForm);
    }
}

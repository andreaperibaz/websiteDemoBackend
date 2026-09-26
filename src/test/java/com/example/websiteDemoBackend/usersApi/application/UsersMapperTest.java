package com.example.websiteDemoBackend.usersApi.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.openapi.usersapi.model.ContactFormDto;
import com.example.websiteDemoBackend.usersApi.domain.model.ContactForm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsersMapperTest {

    private UsersMapper usersMapper;

    @BeforeEach
    void setUp() {
        usersMapper = new UsersMapperImpl();
    }

    @Test
    void from_ContactFormDto_to_ContactForm() {
        // GIVEN
        ContactFormDto dto = new ContactFormDto();
        dto.setName("Test");
        dto.setEmail("test@example.com");
        dto.setMessage("Test test test test test!");
        dto.setMailingList(true);

        // WHEN
        ContactForm contactForm = usersMapper.toContactForm(dto);

        // THEN
        assertNotNull(contactForm);
        assertEquals("Test", contactForm.getName());
        assertEquals("test@example.com", contactForm.getEmail());
        assertEquals("Test test test test test!", contactForm.getMessage());
        assertEquals(true, contactForm.getMailingList());
    }
}

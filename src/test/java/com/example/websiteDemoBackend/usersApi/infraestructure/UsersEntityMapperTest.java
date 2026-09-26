package com.example.websiteDemoBackend.usersApi.infraestructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.websiteDemoBackend.usersApi.domain.model.ContactForm;
import com.example.websiteDemoBackend.usersApi.infraestructure.entities.ContactFormEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsersEntityMapperTest {

    private UsersEntityMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new UsersEntityMapperImpl();
    }

    @Test
    void from_ContactForm_to_ContactFormEntity() {
        // GIVEN
        ContactForm contactForm = new ContactForm();
        contactForm.setName("Test");
        contactForm.setEmail("test@example.com");
        contactForm.setMessage("Test test test test test!");
        contactForm.setMailingList(true);

        // WHEN
        ContactFormEntity entity = mapper.toContactFormEntity(contactForm);

        // THEN
        assertNotNull(entity);
        assertEquals("Test", entity.getName());
        assertEquals("test@example.com", entity.getEmail());
        assertEquals("Test test test test test!", entity.getMessage());
        assertEquals(true, entity.getMailingList());
    }

    @Test
    void from_ContactFormEntity_to_ContactForm() {
        // GIVEN
        ContactFormEntity entity = new ContactFormEntity();
        entity.setName("Test");
        entity.setEmail("test@example.com");
        entity.setMessage("Test test test test test!");
        entity.setMailingList(false);

        // WHEN
        ContactForm contactForm = mapper.toContactForm(entity);

        // THEN
        assertNotNull(contactForm);
        assertEquals("Test", contactForm.getName());
        assertEquals("test@example.com", contactForm.getEmail());
        assertEquals("Test test test test test!", contactForm.getMessage());
        assertEquals(false, contactForm.getMailingList());
    }
}

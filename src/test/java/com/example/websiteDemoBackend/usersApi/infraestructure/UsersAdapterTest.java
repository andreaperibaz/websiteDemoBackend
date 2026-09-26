package com.example.websiteDemoBackend.usersApi.infraestructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import com.example.websiteDemoBackend.usersApi.domain.model.ContactForm;
import com.example.websiteDemoBackend.usersApi.infraestructure.entities.ContactFormEntity;
import com.example.websiteDemoBackend.usersApi.infraestructure.repository.ContactFormRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class UsersAdapterTest {

    @Mock
    private ContactFormRepository contactFormRepository;

    @Mock
    private UsersEntityMapper usersEntityMapper;

    @InjectMocks
    private UsersAdapter usersAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void when_SaveContactForm_expects_ContactFormReturned() {
        // GIVEN
        ContactForm contactForm = new ContactForm();
        contactForm.setName("Test");
        contactForm.setEmail("test@example.com");
        contactForm.setMessage("Test test test test test!");
        contactForm.setMailingList(true);

        ContactFormEntity entity = new ContactFormEntity();
        entity.setName("Test");
        entity.setEmail("test@example.com");
        entity.setMessage("Test test test test test!");
        entity.setMailingList(true);

        when(usersEntityMapper.toContactFormEntity(contactForm)).thenReturn(entity);
        when(contactFormRepository.save(entity)).thenReturn(entity);
        when(usersEntityMapper.toContactForm(entity)).thenReturn(contactForm);

        // WHEN
        ContactForm result = usersAdapter.saveContactForm(contactForm);

        // THEN
        assertEquals("Test", result.getName());
        assertEquals("test@example.com", result.getEmail());
        assertEquals("Test test test test test!", result.getMessage());
        assertEquals(true, result.getMailingList());

        verify(contactFormRepository).save(entity);
    }
}

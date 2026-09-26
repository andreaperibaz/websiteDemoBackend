package com.example.websiteDemoBackend.usersApi.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import com.example.websiteDemoBackend.usersApi.domain.model.ContactForm;
import com.example.websiteDemoBackend.usersApi.domain.port.output.UsersPortOut;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class UsersServiceImplTest {

    @Mock
    private UsersPortOut usersPortOut;

    @InjectMocks
    private UsersServiceImpl usersService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void when_SubmitContactForm_expects_SavedContactForm() {
        // GIVEN
        ContactForm contactForm = new ContactForm();
        contactForm.setName("Test");
        contactForm.setEmail("test@example.com");
        contactForm.setMessage("Test test test test test!");
        contactForm.setMailingList(true);

        when(usersPortOut.saveContactForm(contactForm)).thenReturn(contactForm);

        // WHEN
        ContactForm result = usersService.submitContactForm(contactForm);

        // THEN
        assertEquals("Test", result.getName());
        assertEquals("test@example.com", result.getEmail());
        assertEquals("Test test test test test!", result.getMessage());
        assertEquals(true, result.getMailingList());
        verify(usersPortOut).saveContactForm(contactForm);
    }
}

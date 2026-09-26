package com.example.websiteDemoBackend.booksApi.application;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import com.example.openapi.booksapi.model.BookDto;
import com.example.openapi.booksapi.model.BookListWrapper;
import com.example.websiteDemoBackend.booksApi.domain.model.Book;
import com.example.websiteDemoBackend.booksApi.domain.port.input.BookPortIn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

class BookControllerTest {

    @Mock
    private BookPortIn bookService;

    @Mock
    private BookMapper bookMapper;

    @InjectMocks
    private BookController bookController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void when_GetBooks_expects_BookListWrapper() {

        // GIVEN
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Kafka on the Shore");
        book.setAuthor("Haruki Murakami");

        BookDto dto = new BookDto();
        dto.setId(1L);
        dto.setTitle("Kafka on the Shore");
        dto.setAuthor("Haruki Murakami");

        when(bookService.getBooks()).thenReturn(List.of(book));
        when(bookMapper.toBookDtoList(List.of(book))).thenReturn(List.of(dto));

        // WHEN
        ResponseEntity<BookListWrapper> response = bookController.getBooks();
        BookListWrapper body = response.getBody();

        // THEN
        assertNotNull(body);
        assertEquals(200, body.getCode());
        assertFalse(body.getData().isEmpty());
        assertEquals("Kafka on the Shore", body.getData().get(0).getTitle());
        assertEquals("Haruki Murakami", body.getData().get(0).getAuthor());
    }
}

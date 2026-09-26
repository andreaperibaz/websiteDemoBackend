package com.example.websiteDemoBackend.booksApi.domain.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import com.example.websiteDemoBackend.booksApi.domain.model.Book;
import com.example.websiteDemoBackend.booksApi.domain.port.output.BookPortOut;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class BookServiceImplTest {

    @Mock
    private BookPortOut bookPortOut;

    private BookServiceImpl bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        bookService = new BookServiceImpl(bookPortOut);
    }

    @Test
    void when_getBooks_expects_BookList() {
        // GIVEN
        List<Book> mockBooks = List.of(book(1L, "Kafka on the Shore", "Haruki Murakami"),
                book(2L, "Norwegian Wood", "Haruki Murakami"));
        when(bookPortOut.findBooks()).thenReturn(mockBooks);

        // WHEN
        List<Book> result = bookService.getBooks();

        // THEN
        assertNotNull(result);
        assertEquals(2, result.size());
        assertBook(result.get(0), 1L, "Kafka on the Shore", "Haruki Murakami");
        assertBook(result.get(1), 2L, "Norwegian Wood", "Haruki Murakami");

        verify(bookPortOut, times(1)).findBooks();
    }

    private Book book(Long id, String title, String author) {
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setAuthor(author);
        return book;
    }

    private void assertBook(Book book, Long id, String title, String author) {
        assertNotNull(book);
        assertEquals(id, book.getId());
        assertEquals(title, book.getTitle());
        assertEquals(author, book.getAuthor());
    }
}

package com.example.websiteDemoBackend.booksApi.infraestructure;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import com.example.websiteDemoBackend.booksApi.domain.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class BookAdapterTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookEntityMapper bookEntityMapper;

    private BookAdapter bookAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        bookAdapter = new BookAdapter(bookRepository, bookEntityMapper);
    }

    @Test
    void when_findBooks_expects_BookList() {
        // GIVEN
        List<BookEntity> entities = List.of(bookEntity(1L, "Kafka on the Shore", "Haruki Murakami"),
                bookEntity(2L, "Norwegian Wood", "Haruki Murakami"));
        List<Book> books = List.of(book(1L, "Kafka on the Shore", "Haruki Murakami"),
                book(2L, "Norwegian Wood", "Haruki Murakami"));

        when(bookRepository.findAll()).thenReturn(entities);
        when(bookEntityMapper.toBookList(entities)).thenReturn(books);

        // WHEN
        List<Book> result = bookAdapter.findBooks();

        // THEN
        assertNotNull(result);
        assertEquals(2, result.size());
        assertBook(result.get(0), 1L, "Kafka on the Shore", "Haruki Murakami");
        assertBook(result.get(1), 2L, "Norwegian Wood", "Haruki Murakami");

        verify(bookRepository, times(1)).findAll();
        verify(bookEntityMapper, times(1)).toBookList(entities);
    }

    private Book book(Long id, String title, String author) {
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setAuthor(author);
        return book;
    }

    private BookEntity bookEntity(Long id, String title, String author) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(id);
        bookEntity.setTitle(title);
        bookEntity.setAuthor(author);
        return bookEntity;
    }

    private void assertBook(Book book, Long id, String title, String author) {
        assertNotNull(book);
        assertEquals(id, book.getId());
        assertEquals(title, book.getTitle());
        assertEquals(author, book.getAuthor());
    }
}

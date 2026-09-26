package com.example.websiteDemoBackend.booksApi.infraestructure;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import com.example.websiteDemoBackend.booksApi.domain.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class BookEntityMapperTest {

    private BookEntityMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = Mappers.getMapper(BookEntityMapper.class);
    }

    @Test
    void from_toBookList_to_ReturnsBookList() {
        // GIVEN
        BookEntity bookEntity1 = bookEntity(1L, "Kafka on the Shore", "Haruki Murakami");
        BookEntity bookEntity2 = bookEntity(2L, "Norwegian Wood", "Haruki Murakami");
        List<BookEntity> entities = List.of(bookEntity1, bookEntity2);

        // WHEN
        List<Book> books = mapper.toBookList(entities);

        // THEN
        assertNotNull(books);
        assertEquals(2, books.size());
        assertBook(books.get(0), 1L, "Kafka on the Shore", "Haruki Murakami");
        assertBook(books.get(1), 2L, "Norwegian Wood", "Haruki Murakami");
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

package com.example.websiteDemoBackend.booksApi.application;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import com.example.openapi.booksapi.model.BookDto;
import com.example.websiteDemoBackend.booksApi.domain.model.Book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class BookMapperTest {

    private BookMapper bookMapper;

    @BeforeEach
    void setUp() {
        bookMapper = Mappers.getMapper(BookMapper.class);
    }

    @Test
    void from_BookDtoList_to_BookDtoList() {
        // GIVEN
        List<Book> books = List.of(book(1L, "Kafka on the Shore", "Haruki Murakami"),
                book(2L, "Norwegian Wood", "Haruki Murakami"));

        // WHEN
        List<BookDto> dtos = bookMapper.toBookDtoList(books);

        // THEN
        assertEquals(2, dtos.size());
        assertBookDto(dtos.get(0), 1L, "Kafka on the Shore", "Haruki Murakami");
        assertBookDto(dtos.get(1), 2L, "Norwegian Wood", "Haruki Murakami");
    }

    @Test
    void from_Book_to_BookDto() {
        // GIVEN
        Book book = book(1L, "Kafka on the Shore", "Haruki Murakami");

        // WHEN
        BookDto dto = bookMapper.toBookDto(book);

        // THEN
        assertBookDto(dto, 1L, "Kafka on the Shore", "Haruki Murakami");
    }

    private Book book(Long id, String title, String author) {
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setAuthor(author);
        return book;
    }

    private void assertBookDto(BookDto dto, Long id, String title, String author) {
        assertNotNull(dto);
        assertEquals(id, dto.getId());
        assertEquals(title, dto.getTitle());
        assertEquals(author, dto.getAuthor());
    }
}

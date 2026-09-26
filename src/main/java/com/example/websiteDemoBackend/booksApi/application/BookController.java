package com.example.websiteDemoBackend.booksApi.application;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.openapi.booksapi.api.BooksApi;
import com.example.openapi.booksapi.model.BookDto;
import com.example.openapi.booksapi.model.BookListWrapper;
import com.example.websiteDemoBackend.booksApi.domain.model.Book;
import com.example.websiteDemoBackend.booksApi.domain.port.input.BookPortIn;

@RestController
public class BookController implements BooksApi {

    private final BookPortIn bookService;
    private final BookMapper bookMapper;

    public BookController(BookPortIn bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @Override
    public ResponseEntity<BookListWrapper> getBooks() {
        List<Book> books = bookService.getBooks();

        List<BookDto> bookDtos = bookMapper.toBookDtoList(books);

        BookListWrapper wrapper = new BookListWrapper();
        wrapper.setCode(HttpStatus.OK.value());
        wrapper.setData(bookDtos);

        return ResponseEntity.ok(wrapper);
    }
}

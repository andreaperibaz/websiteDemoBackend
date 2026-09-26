package com.example.websiteDemoBackend.booksApi.infraestructure;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.websiteDemoBackend.booksApi.domain.model.Book;
import com.example.websiteDemoBackend.booksApi.domain.port.output.BookPortOut;

@Component
public class BookAdapter implements BookPortOut {
    private final BookRepository bookRepository;
    private final BookEntityMapper bookEntityMapper;

    public BookAdapter(BookRepository bookRepository, BookEntityMapper bookEntityMapper) {
        this.bookRepository = bookRepository;
        this.bookEntityMapper = bookEntityMapper;
    }

    @Override
    public List<Book> findBooks() {
        List<BookEntity> entities = bookRepository.findAll();
        List<Book> listBooks = bookEntityMapper.toBookList(entities);
        return listBooks;
    }

}

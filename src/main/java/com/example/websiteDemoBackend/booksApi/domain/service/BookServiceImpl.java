package com.example.websiteDemoBackend.booksApi.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.websiteDemoBackend.booksApi.domain.model.Book;
import com.example.websiteDemoBackend.booksApi.domain.port.input.BookPortIn;
import com.example.websiteDemoBackend.booksApi.domain.port.output.BookPortOut;

@Service
public class BookServiceImpl implements BookPortIn {

    private final BookPortOut bookPortOut;

    public BookServiceImpl(BookPortOut repository) {
        this.bookPortOut = repository;
    }

    @Override
    public List<Book> getBooks() {
        return bookPortOut.findBooks();
    }
}
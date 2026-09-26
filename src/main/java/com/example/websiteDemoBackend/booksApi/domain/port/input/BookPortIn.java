package com.example.websiteDemoBackend.booksApi.domain.port.input;

import java.util.List;

import com.example.websiteDemoBackend.booksApi.domain.model.Book;

public interface BookPortIn {

    List<Book> getBooks();
}
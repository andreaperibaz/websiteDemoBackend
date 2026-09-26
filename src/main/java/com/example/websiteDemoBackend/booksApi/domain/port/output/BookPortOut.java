package com.example.websiteDemoBackend.booksApi.domain.port.output;

import java.util.List;

import com.example.websiteDemoBackend.booksApi.domain.model.Book;

public interface BookPortOut {

    List<Book> findBooks();

}

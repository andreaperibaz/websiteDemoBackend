package com.example.websiteDemoBackend.booksApi.domain.model;

import java.util.List;

import com.example.openapi.booksapi.model.BookDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookListWrapper {
    private int code;
    private List<BookDto> data;
}

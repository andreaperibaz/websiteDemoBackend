package com.example.websiteDemoBackend.booksApi.application;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
    private Long id;
    private String title;
    private String author;
}
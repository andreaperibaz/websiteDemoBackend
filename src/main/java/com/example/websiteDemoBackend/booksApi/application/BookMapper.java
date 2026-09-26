package com.example.websiteDemoBackend.booksApi.application;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.websiteDemoBackend.booksApi.domain.model.Book;
import com.example.openapi.booksapi.model.BookDto;

@Mapper(componentModel = "spring")
public interface BookMapper {

    List<BookDto> toBookDtoList(List<Book> books);

    BookDto toBookDto(Book book);
}

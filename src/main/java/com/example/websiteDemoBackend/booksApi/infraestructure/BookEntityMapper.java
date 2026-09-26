package com.example.websiteDemoBackend.booksApi.infraestructure;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.websiteDemoBackend.booksApi.domain.model.Book;

@Mapper(componentModel = "spring")
public interface BookEntityMapper {

    List<Book> toBookList(List<BookEntity> bookEntities);

}
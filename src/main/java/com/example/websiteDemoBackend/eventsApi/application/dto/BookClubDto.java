package com.example.websiteDemoBackend.eventsApi.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookClubDto {

    private Long id;
    private String eventCode;
    private String selectedBook;

}

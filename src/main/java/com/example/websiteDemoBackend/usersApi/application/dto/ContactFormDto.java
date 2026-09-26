package com.example.websiteDemoBackend.usersApi.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactFormDto {
    private String name;
    private String email;
    private String message;
    private Boolean mailingList;

}

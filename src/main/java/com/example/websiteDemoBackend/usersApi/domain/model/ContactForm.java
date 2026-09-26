package com.example.websiteDemoBackend.usersApi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContactForm {
    private String name;
    private String email;
    private String message;
    private Boolean mailingList;
}

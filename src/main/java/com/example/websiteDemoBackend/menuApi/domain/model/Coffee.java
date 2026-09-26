package com.example.websiteDemoBackend.menuApi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coffee {
    private Long id;
    private String category;
    private String name;
    private String description;
    private Double price;
}
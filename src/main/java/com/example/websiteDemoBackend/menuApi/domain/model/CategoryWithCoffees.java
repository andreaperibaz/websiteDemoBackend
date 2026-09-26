package com.example.websiteDemoBackend.menuApi.domain.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryWithCoffees {

    private Long id;
    private String name;
    private List<Coffee> coffees;
}
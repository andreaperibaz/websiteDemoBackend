package com.example.websiteDemoBackend.menuApi.application.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryWithCoffeesDto {

    private Long id;
    private String name;
    private List<CoffeeDto> coffees;

}

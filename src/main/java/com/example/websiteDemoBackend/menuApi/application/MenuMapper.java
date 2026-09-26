package com.example.websiteDemoBackend.menuApi.application;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;

import com.example.websiteDemoBackend.menuApi.domain.model.Coffee;
import com.example.websiteDemoBackend.menuApi.domain.model.CategoryWithCoffees;
import com.example.openapi.menuapi.model.CoffeeDto;
import com.example.openapi.menuapi.model.CategoryWithCoffeesDto;

@Mapper(componentModel = "spring")
public interface MenuMapper {

    CoffeeDto toCoffeeDto(Coffee coffee);

    default List<CoffeeDto> toCoffeeDtoList(List<Coffee> coffees) {
        if (coffees == null)
            return null;
        return coffees.stream()
                .map(this::toCoffeeDto)
                .collect(Collectors.toList());
    }

    default CategoryWithCoffeesDto toCategoryWithCoffeesDto(CategoryWithCoffees category) {
        if (category == null)
            return null;
        CategoryWithCoffeesDto dto = new CategoryWithCoffeesDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setCoffees(category.getCoffees().stream()
                .sorted(Comparator.comparing(Coffee::getName))
                .map(this::toCoffeeDto)
                .collect(Collectors.toList()));
        return dto;
    }

    default List<CategoryWithCoffeesDto> toCategoryWithCoffeesDtoList(List<CategoryWithCoffees> categories) {
        if (categories == null)
            return null;
        return categories.stream()
                .sorted(Comparator.comparing(CategoryWithCoffees::getId))
                .map(this::toCategoryWithCoffeesDto)
                .collect(Collectors.toList());
    }
}

package com.example.websiteDemoBackend.menuApi.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import com.example.openapi.menuapi.model.CategoryWithCoffeesDto;
import com.example.openapi.menuapi.model.CoffeeDto;
import com.example.openapi.menuapi.model.CategoryWithCoffeesWrapper;
import com.example.openapi.menuapi.model.CoffeeListWrapper;
import com.example.websiteDemoBackend.menuApi.domain.model.CategoryWithCoffees;
import com.example.websiteDemoBackend.menuApi.domain.model.Coffee;
import com.example.websiteDemoBackend.menuApi.domain.port.input.MenuPortIn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

class MenuControllerTest {

    @Mock
    private MenuPortIn menuService;

    @Mock
    private MenuMapper menuMapper;

    @InjectMocks
    private MenuController menuController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void when__GetCoffees_expects_CoffeeListWrapper() {

        // GIVEN
        Coffee coffee = new Coffee();
        coffee.setId(1L);
        coffee.setName("Espresso");
        coffee.setPrice(2.5);

        CoffeeDto coffeeDto = new CoffeeDto();
        coffeeDto.setId(1L);
        coffeeDto.setName("Espresso");
        coffeeDto.setPrice(2.5);

        List<Coffee> coffees = List.of(coffee);
        List<CoffeeDto> coffeeDtos = List.of(coffeeDto);

        when(menuService.getCoffees()).thenReturn(coffees);
        when(menuMapper.toCoffeeDtoList(coffees)).thenReturn(coffeeDtos);

        // WHEN
        ResponseEntity<CoffeeListWrapper> response = menuController.getCoffees();
        CoffeeListWrapper body = response.getBody();

        // THEN
        assertEquals(200, body.getCode());
        assertEquals(coffeeDtos, body.getData());
    }

    @Test
    void when_GetCategoriesWithCoffees_expect_CategoryWithCoffeesWrapper() {

        // GIVEN
        Coffee coffee = new Coffee();
        coffee.setId(1L);
        coffee.setName("Latte");
        coffee.setPrice(3.0);

        CoffeeDto coffeeDto = new CoffeeDto();
        coffeeDto.setId(1L);
        coffeeDto.setName("Latte");
        coffeeDto.setPrice(3.0);

        List<Coffee> coffees = List.of(coffee);
        List<CoffeeDto> coffeeDtos = List.of(coffeeDto);

        CategoryWithCoffees category = new CategoryWithCoffees();
        category.setId(10L);
        category.setName("Hot Drinks");
        category.setCoffees(coffees);

        CategoryWithCoffeesDto categoryDto = new CategoryWithCoffeesDto();
        categoryDto.setId(10L);
        categoryDto.setName("Hot Drinks");
        categoryDto.setCoffees(coffeeDtos);

        List<CategoryWithCoffees> categories = List.of(category);
        List<CategoryWithCoffeesDto> categoryDtos = List.of(categoryDto);

        when(menuService.getCategoriesWithCoffees()).thenReturn(categories);
        when(menuMapper.toCategoryWithCoffeesDtoList(categories)).thenReturn(categoryDtos);

        // WHEN
        ResponseEntity<CategoryWithCoffeesWrapper> response = menuController.getCategoriesWithCoffees();
        CategoryWithCoffeesWrapper body = response.getBody();

        // THEN
        assertEquals(200, body.getCode());
        assertEquals(categoryDtos, body.getData());
    }
}

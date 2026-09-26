package com.example.websiteDemoBackend.menuApi.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import com.example.websiteDemoBackend.menuApi.domain.model.CategoryWithCoffees;
import com.example.websiteDemoBackend.menuApi.domain.model.Coffee;
import com.example.websiteDemoBackend.menuApi.domain.port.output.MenuPortOut;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class MenuServiceImplTest {

    @Mock
    private MenuPortOut repository;

    @InjectMocks
    private MenuServiceImpl menuService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void when_GetCoffees_expects_CoffeeList() {

        // GIVEN
        Coffee coffee = new Coffee();
        coffee.setId(1L);
        coffee.setName("Espresso");
        coffee.setPrice(2.5);

        List<Coffee> coffees = List.of(coffee);
        when(repository.findCoffees()).thenReturn(coffees);

        // WHEN
        List<Coffee> result = menuService.getCoffees();

        // THEN
        assertEquals(1, result.size());
        assertEquals("Espresso", result.get(0).getName());
        assertEquals(2.5, result.get(0).getPrice());
    }

    @Test
    void when_GetCategoriesWithCoffees_expects_CategoryWithCoffeesList() {

        // GIVEN
        Coffee coffee = new Coffee();
        coffee.setId(1L);
        coffee.setName("Latte");
        coffee.setPrice(3.0);

        List<Coffee> coffees = List.of(coffee);

        CategoryWithCoffees category = new CategoryWithCoffees();
        category.setId(10L);
        category.setName("Hot Drinks");
        category.setCoffees(coffees);

        List<CategoryWithCoffees> categories = List.of(category);
        when(repository.findCategoriesWithCoffees()).thenReturn(categories);

        // WHEN
        List<CategoryWithCoffees> result = menuService.getCategoriesWithCoffees();

        // THEN
        assertEquals(1, result.size());
        assertEquals("Hot Drinks", result.get(0).getName());
        assertEquals(1, result.get(0).getCoffees().size());
        assertEquals("Latte", result.get(0).getCoffees().get(0).getName());
    }
}

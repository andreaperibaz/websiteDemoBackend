package com.example.websiteDemoBackend.menuApi.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import com.example.websiteDemoBackend.menuApi.domain.model.CategoryWithCoffees;
import com.example.websiteDemoBackend.menuApi.domain.model.Coffee;
import com.example.openapi.menuapi.model.CategoryWithCoffeesDto;
import com.example.openapi.menuapi.model.CoffeeDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MenuMapperTest {

    private MenuMapper menuMapper;

    @BeforeEach
    void setUp() {
        menuMapper = new MenuMapperImpl();
    }

    @Test
    void from_Coffee_to_CoffeeDto() {
        // GIVEN
        Coffee coffee = createCoffee(1L, "Espresso", 2.5);

        // WHEN
        CoffeeDto dto = menuMapper.toCoffeeDto(coffee);

        // THEN
        assertNotNull(dto);
        assertEquals(1L, dto.getId());
        assertEquals("Espresso", dto.getName());
        assertEquals(2.5, dto.getPrice());
    }

    @Test
    void from_CoffeeList_to_CoffeeDtoList() {
        // GIVEN
        List<Coffee> coffees = List.of(
                createCoffee(1L, "Latte", 3.0),
                createCoffee(2L, "Americano", 2.0));

        // WHEN
        List<CoffeeDto> dtos = menuMapper.toCoffeeDtoList(coffees);

        // THEN
        assertNotNull(dtos);
        assertEquals(2, dtos.size());
        assertEquals("Latte", dtos.get(0).getName());
        assertEquals("Americano", dtos.get(1).getName());
    }

    @Test
    void from_CategoryWithCoffees_to_CategoryWithCoffeesDto() {
        // GIVEN
        List<Coffee> coffees = List.of(
                createCoffee(1L, "Latte", 3.0),
                createCoffee(2L, "Americano", 2.0));
        CategoryWithCoffees category = createCategory(10L, "Hot Drinks", coffees);

        // WHEN
        CategoryWithCoffeesDto dto = menuMapper.toCategoryWithCoffeesDto(category);

        // THEN
        assertNotNull(dto);
        assertEquals(10L, dto.getId());
        assertEquals("Hot Drinks", dto.getName());
        assertEquals(2, dto.getCoffees().size());
        assertEquals("Americano", dto.getCoffees().get(0).getName());
        assertEquals("Latte", dto.getCoffees().get(1).getName());
    }

    @Test
    void from_CategoryWithCoffeesList_To_CategoryWithCoffeesDtoList() {
        // GIVEN
        CategoryWithCoffees cat1 = createCategory(20L, "Cold Drinks", List.of());
        CategoryWithCoffees cat2 = createCategory(10L, "Hot Drinks", List.of());
        List<CategoryWithCoffees> categories = List.of(cat1, cat2);

        // WHEN
        List<CategoryWithCoffeesDto> dtos = menuMapper.toCategoryWithCoffeesDtoList(categories);

        // THEN
        assertNotNull(dtos);
        assertEquals(2, dtos.size());
        assertEquals(10L, dtos.get(0).getId());
        assertEquals(20L, dtos.get(1).getId());
    }

    private Coffee createCoffee(long id, String name, double price) {
        Coffee c = new Coffee();
        c.setId(id);
        c.setName(name);
        c.setPrice(price);
        return c;
    }

    private CategoryWithCoffees createCategory(long id, String name, List<Coffee> coffees) {
        CategoryWithCoffees cat = new CategoryWithCoffees();
        cat.setId(id);
        cat.setName(name);
        cat.setCoffees(coffees);
        return cat;
    }

}

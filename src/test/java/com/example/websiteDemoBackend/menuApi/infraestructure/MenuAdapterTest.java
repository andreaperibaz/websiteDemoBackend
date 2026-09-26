package com.example.websiteDemoBackend.menuApi.infraestructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import com.example.websiteDemoBackend.menuApi.domain.model.CategoryWithCoffees;
import com.example.websiteDemoBackend.menuApi.domain.model.Coffee;
import com.example.websiteDemoBackend.menuApi.infraestructure.entities.CategoryEntity;
import com.example.websiteDemoBackend.menuApi.infraestructure.entities.CoffeeEntity;
import com.example.websiteDemoBackend.menuApi.infraestructure.repositories.CategoryRepository;
import com.example.websiteDemoBackend.menuApi.infraestructure.repositories.CoffeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class MenuAdapterTest {

    @Mock
    private CoffeeRepository coffeeRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private MenuEntityMapper menuEntityMapper;

    @InjectMocks
    private MenuAdapter menuAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void when_FindCoffees_expects_CoffeeList() {

        // GIVEN
        CoffeeEntity coffeeEntity = new CoffeeEntity();
        coffeeEntity.setId(1L);
        coffeeEntity.setName("Espresso");
        coffeeEntity.setPrice(2.5);

        List<CoffeeEntity> coffeeEntities = List.of(coffeeEntity);

        Coffee coffee = new Coffee();
        coffee.setId(1L);
        coffee.setName("Espresso");
        coffee.setPrice(2.5);

        List<Coffee> coffees = List.of(coffee);

        when(coffeeRepository.findAll()).thenReturn(coffeeEntities);
        when(menuEntityMapper.toCoffeeList(coffeeEntities)).thenReturn(coffees);

        // WHEN
        List<Coffee> result = menuAdapter.findCoffees();

        // THEN
        assertEquals(1, result.size());
        assertEquals("Espresso", result.get(0).getName());
        assertEquals(2.5, result.get(0).getPrice());
    }

    @Test
    void when_FindCategoriesWithCoffees_expects_CategoryWithCoffeesList() {

        // GIVEN
        CoffeeEntity coffeeEntity = new CoffeeEntity();
        coffeeEntity.setId(1L);
        coffeeEntity.setName("Latte");
        coffeeEntity.setPrice(3.0);

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(10L);
        categoryEntity.setName("Hot Drinks");
        categoryEntity.setCoffees(List.of(coffeeEntity));

        List<CategoryEntity> categoryEntities = List.of(categoryEntity);

        Coffee coffee = new Coffee();
        coffee.setId(1L);
        coffee.setName("Latte");
        coffee.setPrice(3.0);

        CategoryWithCoffees category = new CategoryWithCoffees();
        category.setId(10L);
        category.setName("Hot Drinks");
        category.setCoffees(List.of(coffee));

        List<CategoryWithCoffees> categories = List.of(category);

        when(categoryRepository.findAll()).thenReturn(categoryEntities);
        when(menuEntityMapper.toCategoryWithCoffeeList(categoryEntities)).thenReturn(categories);

        // WHEN
        List<CategoryWithCoffees> result = menuAdapter.findCategoriesWithCoffees();

        // THEN
        assertEquals(1, result.size());
        assertEquals("Hot Drinks", result.get(0).getName());
        assertEquals(1, result.get(0).getCoffees().size());
        assertEquals("Latte", result.get(0).getCoffees().get(0).getName());
        assertEquals(3.0, result.get(0).getCoffees().get(0).getPrice());
    }
}

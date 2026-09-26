package com.example.websiteDemoBackend.menuApi.infraestructure;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import com.example.websiteDemoBackend.menuApi.domain.model.CategoryWithCoffees;
import com.example.websiteDemoBackend.menuApi.domain.model.Coffee;
import com.example.websiteDemoBackend.menuApi.infraestructure.entities.CategoryEntity;
import com.example.websiteDemoBackend.menuApi.infraestructure.entities.CoffeeEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MenuEntityMapperTest {

    private MenuEntityMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new MenuEntityMapperImpl();
    }

    @Test
    void from_CoffeeEntity_to_Coffee() {
        // GIVEN
        CategoryEntity category = createCategoryEntity(1L, "Hot Drinks");
        CoffeeEntity coffeeEntity = createCoffeeEntity(1L, "Espresso", 2.5, category);

        // WHEN
        Coffee coffee = mapper.toCoffee(coffeeEntity);

        // THEN
        assertNotNull(coffee);
        assertEquals(1L, coffee.getId());
        assertEquals("Espresso", coffee.getName());
        assertEquals(2.5, coffee.getPrice());
        assertEquals("Hot Drinks", coffee.getCategory());
    }

    @Test
    void from_Coffee_to_CoffeeEntity() {
        // GIVEN
        Coffee coffee = new Coffee();
        coffee.setId(1L);
        coffee.setName("Latte");
        coffee.setPrice(3.0);
        coffee.setCategory("Cold Drinks");

        // WHEN
        CoffeeEntity entity = mapper.toCoffeeEntity(coffee);

        // THEN
        assertNotNull(entity);
        assertEquals("Latte", entity.getName());
        assertEquals(3.0, entity.getPrice());
        assertEquals("Cold Drinks", entity.getCategory().getName());
    }

    @Test
    void from_CoffeeEntityList_to_CoffeeList() {
        // GIVEN
        CategoryEntity category = createCategoryEntity(1L, "Hot Drinks");
        CoffeeEntity c1 = createCoffeeEntity(1L, "Espresso", 2.5, category);
        CoffeeEntity c2 = createCoffeeEntity(2L, "Latte", 3.0, category);

        List<CoffeeEntity> entities = List.of(c1, c2);

        // WHEN
        List<Coffee> dtos = mapper.toCoffeeList(entities);

        // THEN
        assertEquals(2, dtos.size());
        assertEquals("Espresso", dtos.get(0).getName());
        assertEquals("Latte", dtos.get(1).getName());
    }

    @Test
    void from_CategoryWithCoffeeEntity_to_CategoryWithCoffees() {
        // GIVEN
        CategoryEntity category = createCategoryEntity(1L, "Hot Drinks");
        category.setCoffees(List.of(
                createCoffeeEntity(1L, "Espresso", 2.5, category),
                createCoffeeEntity(2L, "Latte", 3.0, category)));

        // WHEN
        CategoryWithCoffees dto = mapper.toCategoryWithCoffees(category);

        // THEN
        assertNotNull(dto);
        assertEquals("Hot Drinks", dto.getName());
        assertEquals(2, dto.getCoffees().size());
        assertEquals("Espresso", dto.getCoffees().get(0).getName());
    }

    @Test
    void from_CategoryEntityList_to_CategoryWithCoffeeList() {
        // GIVEN
        CategoryEntity cat1 = createCategoryEntity(1L, "Hot Drinks");
        CategoryEntity cat2 = createCategoryEntity(2L, "Cold Drinks");
        List<CategoryEntity> categories = List.of(cat1, cat2);

        // WHEN
        List<CategoryWithCoffees> dtos = mapper.toCategoryWithCoffeeList(categories);

        // THEN
        assertEquals(2, dtos.size());
        assertEquals("Hot Drinks", dtos.get(0).getName());
        assertEquals("Cold Drinks", dtos.get(1).getName());
    }

    private CoffeeEntity createCoffeeEntity(Long id, String name, double price, CategoryEntity category) {
        CoffeeEntity coffeeEntity = new CoffeeEntity();
        coffeeEntity.setId(id);
        coffeeEntity.setName(name);
        coffeeEntity.setPrice(price);
        coffeeEntity.setCategory(category);
        return coffeeEntity;
    }

    private CategoryEntity createCategoryEntity(Long id, String name) {
        CategoryEntity categotyEntity = new CategoryEntity();
        categotyEntity.setId(id);
        categotyEntity.setName(name);
        return categotyEntity;
    }
}

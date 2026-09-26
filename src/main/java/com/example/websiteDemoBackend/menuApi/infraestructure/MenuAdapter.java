package com.example.websiteDemoBackend.menuApi.infraestructure;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.websiteDemoBackend.menuApi.domain.model.CategoryWithCoffees;
import com.example.websiteDemoBackend.menuApi.domain.model.Coffee;
import com.example.websiteDemoBackend.menuApi.domain.port.output.MenuPortOut;
import com.example.websiteDemoBackend.menuApi.infraestructure.entities.CategoryEntity;
import com.example.websiteDemoBackend.menuApi.infraestructure.entities.CoffeeEntity;
import com.example.websiteDemoBackend.menuApi.infraestructure.repositories.CategoryRepository;
import com.example.websiteDemoBackend.menuApi.infraestructure.repositories.CoffeeRepository;

@Component
public class MenuAdapter implements MenuPortOut {
    private final CoffeeRepository menuRepository;
    private final MenuEntityMapper menuEntityMapper;
    private final CategoryRepository categoryRepository;

    public MenuAdapter(CoffeeRepository menuRepository, MenuEntityMapper menuEntityMapper,
            CategoryRepository categoryRepository) {
        this.menuRepository = menuRepository;
        this.menuEntityMapper = menuEntityMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Coffee> findCoffees() {
        List<CoffeeEntity> entities = menuRepository.findAll();
        List<Coffee> listCoffee = menuEntityMapper.toCoffeeList(entities);
        return listCoffee;
    }

    @Override
    public List<CategoryWithCoffees> findCategoriesWithCoffees() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        return menuEntityMapper.toCategoryWithCoffeeList(categoryEntities);
    }

}

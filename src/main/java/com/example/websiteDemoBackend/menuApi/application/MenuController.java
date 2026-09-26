package com.example.websiteDemoBackend.menuApi.application;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.openapi.menuapi.api.MenuApi;
import com.example.openapi.menuapi.model.CategoryWithCoffeesDto;
import com.example.openapi.menuapi.model.CategoryWithCoffeesWrapper;
import com.example.openapi.menuapi.model.CoffeeDto;
import com.example.openapi.menuapi.model.CoffeeListWrapper;
import com.example.websiteDemoBackend.menuApi.domain.model.CategoryWithCoffees;
import com.example.websiteDemoBackend.menuApi.domain.model.Coffee;
import com.example.websiteDemoBackend.menuApi.domain.port.input.MenuPortIn;

@RestController
public class MenuController implements MenuApi {

    private final MenuPortIn menuService;
    private final MenuMapper menuMapper;

    public MenuController(MenuPortIn menuService, MenuMapper menuMapper) {
        this.menuService = menuService;
        this.menuMapper = menuMapper;
    }

    @Override
    public ResponseEntity<CoffeeListWrapper> getCoffees() {

        List<Coffee> coffees = menuService.getCoffees();
        List<CoffeeDto> coffeeDtos = menuMapper.toCoffeeDtoList(coffees);

        CoffeeListWrapper wrapper = new CoffeeListWrapper();
        wrapper.setCode(200);
        wrapper.setData(coffeeDtos);

        return ResponseEntity.ok(wrapper);
    }

    @Override
    public ResponseEntity<CategoryWithCoffeesWrapper> getCategoriesWithCoffees() {

        List<CategoryWithCoffees> categories = menuService.getCategoriesWithCoffees();
        List<CategoryWithCoffeesDto> categoryDtos = menuMapper.toCategoryWithCoffeesDtoList(categories);

        CategoryWithCoffeesWrapper wrapper = new CategoryWithCoffeesWrapper();
        wrapper.setCode(200);
        wrapper.setData(categoryDtos);

        return ResponseEntity.ok(wrapper);
    }
}

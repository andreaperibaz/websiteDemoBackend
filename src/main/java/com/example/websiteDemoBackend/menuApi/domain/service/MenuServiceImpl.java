package com.example.websiteDemoBackend.menuApi.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.websiteDemoBackend.menuApi.domain.model.CategoryWithCoffees;
import com.example.websiteDemoBackend.menuApi.domain.model.Coffee;
import com.example.websiteDemoBackend.menuApi.domain.port.input.MenuPortIn;
import com.example.websiteDemoBackend.menuApi.domain.port.output.MenuPortOut;

@Service
public class MenuServiceImpl implements MenuPortIn {

    private final MenuPortOut repository;

    public MenuServiceImpl(MenuPortOut repository) {
        this.repository = repository;
    }

    @Override
    public List<Coffee> getCoffees() {
        return repository.findCoffees();
    }

    @Override
    public List<CategoryWithCoffees> getCategoriesWithCoffees() {
        return repository.findCategoriesWithCoffees();
    }
}
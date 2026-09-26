package com.example.websiteDemoBackend.menuApi.domain.port.input;

import java.util.List;

import com.example.websiteDemoBackend.menuApi.domain.model.CategoryWithCoffees;
import com.example.websiteDemoBackend.menuApi.domain.model.Coffee;

public interface MenuPortIn {

    List<Coffee> getCoffees();

    List<CategoryWithCoffees> getCategoriesWithCoffees();

}
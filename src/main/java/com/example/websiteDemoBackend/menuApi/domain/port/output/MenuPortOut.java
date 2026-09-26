package com.example.websiteDemoBackend.menuApi.domain.port.output;

import java.util.List;

import com.example.websiteDemoBackend.menuApi.domain.model.CategoryWithCoffees;
import com.example.websiteDemoBackend.menuApi.domain.model.Coffee;

public interface MenuPortOut {

    List<Coffee> findCoffees();

    List<CategoryWithCoffees> findCategoriesWithCoffees();

}

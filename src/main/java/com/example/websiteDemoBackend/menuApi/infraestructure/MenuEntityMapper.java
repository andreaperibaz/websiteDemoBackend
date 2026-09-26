package com.example.websiteDemoBackend.menuApi.infraestructure;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import java.util.List;
import com.example.websiteDemoBackend.menuApi.domain.model.Coffee;
import com.example.websiteDemoBackend.menuApi.infraestructure.entities.CategoryEntity;
import com.example.websiteDemoBackend.menuApi.infraestructure.entities.CoffeeEntity;
import com.example.websiteDemoBackend.menuApi.domain.model.CategoryWithCoffees;

@Mapper(componentModel = "spring")
public interface MenuEntityMapper {

    @Mapping(source = "category", target = "category", qualifiedByName = "mapCategoryEntityToString")
    Coffee toCoffee(CoffeeEntity coffeeEntity);

    @Mapping(source = "category", target = "category", qualifiedByName = "mapStringToCategoryEntity")
    CoffeeEntity toCoffeeEntity(Coffee coffee);

    List<Coffee> toCoffeeList(List<CoffeeEntity> CoffeeEntitiesList);

    List<CoffeeEntity> toCoffeeEntityList(List<Coffee> coffeesList);

    @Named("mapCategoryEntityToString")
    default String mapCategoryEntityToString(CategoryEntity categoryEntity) {
        return categoryEntity != null ? categoryEntity.getName() : null;
    }

    @Named("mapStringToCategoryEntity")
    default CategoryEntity mapStringToCategoryEntity(String categoryName) {
        if (categoryName == null)
            return null;
        CategoryEntity entity = new CategoryEntity();
        entity.setName(categoryName);
        return entity;
    }

    @Mapping(source = "coffees", target = "coffees")
    CategoryWithCoffees toCategoryWithCoffees(CategoryEntity categoryEntity);

    List<CategoryWithCoffees> toCategoryWithCoffeeList(List<CategoryEntity> categoryEntitiesList);
}

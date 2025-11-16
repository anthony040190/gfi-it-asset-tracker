package com.codeandchill.gfi_asset_inventory.mappers.category;

import com.codeandchill.gfi_asset_inventory.dtos.category.CategoryDto;
import com.codeandchill.gfi_asset_inventory.dtos.category.RegisterCategoryDto;
import com.codeandchill.gfi_asset_inventory.dtos.category.UpdateCategoryDto;
import com.codeandchill.gfi_asset_inventory.entities.category.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toDto(Category category);
    Category toEntity(RegisterCategoryDto request);
    void update(UpdateCategoryDto request, @MappingTarget Category category);
}

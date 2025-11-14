package com.codeandchill.gfi_asset_inventory.mappers.category;

import com.codeandchill.gfi_asset_inventory.dtos.category.CategoryDto;
import com.codeandchill.gfi_asset_inventory.entities.category.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toDto(Category category);
}

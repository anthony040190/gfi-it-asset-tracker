package com.codeandchill.gfi_asset_inventory.mappers;

import com.codeandchill.gfi_asset_inventory.dtos.BrandDto;
import com.codeandchill.gfi_asset_inventory.entities.Brand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    BrandDto toDto(Brand brand);

}

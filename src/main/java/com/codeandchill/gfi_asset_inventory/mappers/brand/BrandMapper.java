package com.codeandchill.gfi_asset_inventory.mappers.brand;

import com.codeandchill.gfi_asset_inventory.dtos.brand.BrandDto;
import com.codeandchill.gfi_asset_inventory.dtos.brand.RegisterBrandRequest;
import com.codeandchill.gfi_asset_inventory.dtos.brand.UpdateBrandRequest;
import com.codeandchill.gfi_asset_inventory.entities.brand.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    BrandDto toDto(Brand brand);
    Brand toEntity(RegisterBrandRequest request);
    void update(UpdateBrandRequest request, @MappingTarget Brand brand);
}

package com.codeandchill.gfi_asset_inventory.mappers.accessory;

import com.codeandchill.gfi_asset_inventory.dtos.accessory.AccessoryDto;
import com.codeandchill.gfi_asset_inventory.entities.accessory.Accessory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccessoryMapper {
    AccessoryDto toDto(Accessory accessory);
}

package com.codeandchill.gfi_asset_inventory.mappers.computer;

import com.codeandchill.gfi_asset_inventory.dtos.computer.ComputerDto;
import com.codeandchill.gfi_asset_inventory.entities.computer.Computer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ComputerMapper {
    @Mapping(source = "brand.brandName", target = "brandName")
    ComputerDto toDto(Computer computer);
}

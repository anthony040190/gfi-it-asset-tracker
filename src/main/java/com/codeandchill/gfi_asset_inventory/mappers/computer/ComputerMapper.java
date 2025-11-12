package com.codeandchill.gfi_asset_inventory.mappers.computer;

import com.codeandchill.gfi_asset_inventory.dtos.computer.ComputerDto;
import com.codeandchill.gfi_asset_inventory.dtos.computer.RegisterComputerDto;
import com.codeandchill.gfi_asset_inventory.entities.computer.Computer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ComputerMapper {
    @Mapping(source = "brand.brandName", target = "brandName")
    ComputerDto toDto(Computer computer);
    Computer toEntity(RegisterComputerDto request);
    void update(RegisterComputerDto request, @MappingTarget Computer computer);
}

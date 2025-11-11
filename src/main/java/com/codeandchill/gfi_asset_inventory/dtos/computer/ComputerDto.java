package com.codeandchill.gfi_asset_inventory.dtos.computer;

import com.codeandchill.gfi_asset_inventory.entities.brand.Brand;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ComputerDto {
    private Long id;
    private String model;
    private String serialNumber;
    private double price;
    private Long brandId;
}

package com.codeandchill.gfi_asset_inventory.dtos.accessory;

import com.codeandchill.gfi_asset_inventory.entities.brand.Brand;
import lombok.Getter;

@Getter
public class AccessoryDto {
    private Long id;
    private String name;
    private String model;
    private String serialNumber;
    private double price;
    private Brand brandName;
}

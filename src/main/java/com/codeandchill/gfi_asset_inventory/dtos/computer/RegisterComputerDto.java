package com.codeandchill.gfi_asset_inventory.dtos.computer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterComputerDto {
    private String model;
    private String serialNumber;
    private double price;
    private Long brandId;
}

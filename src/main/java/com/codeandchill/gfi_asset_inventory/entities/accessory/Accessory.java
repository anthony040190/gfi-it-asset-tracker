package com.codeandchill.gfi_asset_inventory.entities.accessory;

import com.codeandchill.gfi_asset_inventory.entities.brand.Brand;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accessory")
public class Accessory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String model;
    private String serialNumber;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
}

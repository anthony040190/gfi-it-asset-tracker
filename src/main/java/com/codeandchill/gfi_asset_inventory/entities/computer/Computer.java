package com.codeandchill.gfi_asset_inventory.entities.computer;

import com.codeandchill.gfi_asset_inventory.entities.brand.Brand;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "computer")
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "brand_id") // this will create a column in computer table name brand_id
    private Brand brand;

    private String model;
    private String serialNumber;
    private double price;
}

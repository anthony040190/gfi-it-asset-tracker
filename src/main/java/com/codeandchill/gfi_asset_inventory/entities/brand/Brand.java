package com.codeandchill.gfi_asset_inventory.entities.brand;

import com.codeandchill.gfi_asset_inventory.entities.accessory.Accessory;
import com.codeandchill.gfi_asset_inventory.entities.computer.Computer;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand", nullable = false, unique = true)
    private String brandName;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Computer> computers = new ArrayList<>();

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Accessory> accessories = new ArrayList<>();
}

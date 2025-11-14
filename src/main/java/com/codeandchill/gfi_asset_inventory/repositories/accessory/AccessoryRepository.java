package com.codeandchill.gfi_asset_inventory.repositories.accessory;

import com.codeandchill.gfi_asset_inventory.entities.accessory.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessoryRepository extends JpaRepository<Accessory, Long> {
}

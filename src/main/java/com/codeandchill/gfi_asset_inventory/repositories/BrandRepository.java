package com.codeandchill.gfi_asset_inventory.repositories;

import com.codeandchill.gfi_asset_inventory.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}

package com.codeandchill.gfi_asset_inventory.repositories.category;

import com.codeandchill.gfi_asset_inventory.entities.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

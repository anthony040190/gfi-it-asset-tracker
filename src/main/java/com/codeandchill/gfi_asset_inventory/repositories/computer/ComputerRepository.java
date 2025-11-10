package com.codeandchill.gfi_asset_inventory.repositories.computer;

import com.codeandchill.gfi_asset_inventory.entities.computer.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerRepository extends JpaRepository<Computer, Long> {
}

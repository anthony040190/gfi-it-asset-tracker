package com.codeandchill.gfi_asset_inventory.controllers.accessory;

import com.codeandchill.gfi_asset_inventory.dtos.accessory.AccessoryDto;
import com.codeandchill.gfi_asset_inventory.mappers.accessory.AccessoryMapper;
import com.codeandchill.gfi_asset_inventory.repositories.accessory.AccessoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/accessory")
public class AccessoryController {
    private final AccessoryRepository accessoryRepository;
    private final AccessoryMapper accessoryMapper;

    @GetMapping
    public Iterable<AccessoryDto> getAllAccessories() {
        return accessoryRepository.findAll()
                .stream()
                .map(accessoryMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccessoryDto> getAccessory(@PathVariable Long id) {
        var accessory = accessoryRepository.findById(id).orElse(null);

        if(accessory == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(accessoryMapper.toDto(accessory));
    }
}

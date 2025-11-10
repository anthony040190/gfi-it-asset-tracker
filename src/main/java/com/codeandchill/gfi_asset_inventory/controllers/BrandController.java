package com.codeandchill.gfi_asset_inventory.controllers;

import com.codeandchill.gfi_asset_inventory.dtos.BrandDto;
import com.codeandchill.gfi_asset_inventory.entities.Brand;
import com.codeandchill.gfi_asset_inventory.mappers.BrandMapper;
import com.codeandchill.gfi_asset_inventory.repositories.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/brands")
@AllArgsConstructor
public class BrandController {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    @GetMapping
    public Iterable<BrandDto> getAllBrands() {

        return brandRepository.findAll()
                .stream()
                .map(brandMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandDto> getBrand(@PathVariable Long id) {

        var brand = brandRepository.findById(id).orElse(null);

        if(brand == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(brandMapper.toDto(brand));
    }

    public ResponseEntity<BrandDto> addBrand(@RequestBody Brand brand, UriComponentsBuilder uriComponentsBuilder) {



        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Long id) {

        var brand = brandRepository.findById(id).orElse(null);

        if(brand == null)
            return ResponseEntity.notFound().build();

        brandRepository.delete(brand);
        return ResponseEntity.noContent().build();

    }
}

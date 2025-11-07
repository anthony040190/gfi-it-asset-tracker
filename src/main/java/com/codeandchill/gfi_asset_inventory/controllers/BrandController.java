package com.codeandchill.gfi_asset_inventory.controllers;

import com.codeandchill.gfi_asset_inventory.dtos.BrandDto;
import com.codeandchill.gfi_asset_inventory.mappers.BrandMapper;
import com.codeandchill.gfi_asset_inventory.repositories.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brands")
@AllArgsConstructor
public class BrandController {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    @GetMapping
    public Iterable<BrandDto> getAllUsers() {

        return brandRepository.findAll()
                .stream()
                .map(brandMapper::toDto)
                .toList();
    }
}

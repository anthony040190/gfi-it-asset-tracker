package com.codeandchill.gfi_asset_inventory.controllers;

import com.codeandchill.gfi_asset_inventory.dtos.BrandDto;
import com.codeandchill.gfi_asset_inventory.dtos.RegisterBrandRequest;
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
    // Create Mapper for the fields
    // Convert to Entity
    // Save it = brandRepository.save(Entity)
    // Create DTO version = brandMapper.toDto(Entity)
    // Create URI = uriComponentsBuilder.path("/brands/{id}").buildAndExpand(brandDto.getId()).toUri();
    // Return ResponseEntity.created(uri).body(dto);
    @PostMapping
    public ResponseEntity<BrandDto> addBrand(@RequestBody RegisterBrandRequest request, UriComponentsBuilder uriComponentsBuilder) {
        // Have to create another DTO(RegisterBrandRequest) which is consist only the fields that will be saved except PK
        // Since RegisterBrandRequest is DTO it needs to be converted to Entity because repository is only accepting Entity format
        var brand = brandMapper.toEntity(request);
        brandRepository.save(brand);

        // Need to get the DTO format in able to create an uri
        var brandDto = brandMapper.toDto(brand);
        var uri = uriComponentsBuilder.path("/brands/{id}").buildAndExpand(brandDto.getId()).toUri();

        return ResponseEntity.created(uri).body(brandDto);
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

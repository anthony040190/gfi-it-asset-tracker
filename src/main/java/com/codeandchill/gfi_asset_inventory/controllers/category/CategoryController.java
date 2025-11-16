package com.codeandchill.gfi_asset_inventory.controllers.category;

import com.codeandchill.gfi_asset_inventory.dtos.category.CategoryDto;
import com.codeandchill.gfi_asset_inventory.dtos.category.RegisterCategoryDto;
import com.codeandchill.gfi_asset_inventory.mappers.category.CategoryMapper;
import com.codeandchill.gfi_asset_inventory.repositories.category.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@AllArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public Iterable<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Long id) {

        var category = categoryRepository.findById(id).orElse(null);

        if(category == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(categoryMapper.toDto(category));

    }

    @PostMapping
    public ResponseEntity<CategoryDto> addCategory(
            @RequestBody RegisterCategoryDto request,
            UriComponentsBuilder uriComponentsBuilder
            ) {

        var category = categoryMapper.toEntity(request);
        categoryRepository.save(category);

        var categoryDto = categoryMapper.toDto(category);
        var uri = uriComponentsBuilder.path("/categories/{id}").buildAndExpand(categoryDto.getId()).toUri();

        return ResponseEntity.created(uri).body(categoryDto);
    }
}

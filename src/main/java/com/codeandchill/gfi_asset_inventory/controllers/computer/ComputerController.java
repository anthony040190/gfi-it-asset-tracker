package com.codeandchill.gfi_asset_inventory.controllers.computer;

import com.codeandchill.gfi_asset_inventory.dtos.computer.ComputerDto;
import com.codeandchill.gfi_asset_inventory.dtos.computer.RegisterComputerDto;
import com.codeandchill.gfi_asset_inventory.mappers.computer.ComputerMapper;
import com.codeandchill.gfi_asset_inventory.repositories.brand.BrandRepository;
import com.codeandchill.gfi_asset_inventory.repositories.computer.ComputerRepository;
import lombok.AllArgsConstructor;
import org.mapstruct.ap.shaded.freemarker.core.ReturnInstruction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/computers")
@AllArgsConstructor
public class ComputerController {

    private final ComputerRepository computerRepository;
    private final ComputerMapper computerMapper;
    private final BrandRepository brandRepository;

    @GetMapping
    public Iterable<ComputerDto> getAllComputers() {
        return computerRepository.findAll()
                .stream()
                .map(computerMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComputerDto> getComputer(@PathVariable Long id) {
        var computer = computerRepository.findById(id).orElse(null);

        if(computer == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(computerMapper.toDto(computer));
    }

    @PostMapping
    public ResponseEntity<ComputerDto> addComputer(
            @RequestBody RegisterComputerDto request,
            UriComponentsBuilder uriComponentsBuilder) {

        var computer = computerMapper.toEntity(request);

        var brand = brandRepository.findById(request.getBrandId()).orElse(null);
        if(brand == null)
            return ResponseEntity.notFound().build();

        computer.setBrand(brand);
        computerRepository.save(computer);

        var computerDto = computerMapper.toDto(computer);
        var uri = uriComponentsBuilder.path("/computers/{id}").buildAndExpand(computerDto.getId()).toUri();

        return ResponseEntity.created(uri).body(computerDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComputerDto> updateComputer(@PathVariable Long id, @RequestBody RegisterComputerDto request) {
        var computer = computerRepository.findById(id).orElse(null);
        var brand = brandRepository.findById(request.getBrandId()).orElse(null);

        if(computer == null || brand == null)
            return ResponseEntity.notFound().build();

        computer.setBrand(brand);
        computerMapper.update(request, computer);
        computerRepository.save(computer);

        return ResponseEntity.ok(computerMapper.toDto(computer));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComputer(@PathVariable Long id) {
        var computer = computerRepository.findById(id).orElse(null);
        if(computer == null)
            return ResponseEntity.notFound().build();

        computerRepository.delete(computer);
        return ResponseEntity.noContent().build();
    }


}

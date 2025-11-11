package com.codeandchill.gfi_asset_inventory.controllers.computer;

import com.codeandchill.gfi_asset_inventory.dtos.computer.ComputerDto;
import com.codeandchill.gfi_asset_inventory.mappers.computer.ComputerMapper;
import com.codeandchill.gfi_asset_inventory.repositories.computer.ComputerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/computers")
@AllArgsConstructor
public class ComputerController {

    private final ComputerRepository computerRepository;
    private final ComputerMapper computerMapper;

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

    
}

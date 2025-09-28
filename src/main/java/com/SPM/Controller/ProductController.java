package com.SPM.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SPM.DTO.ProductDTO;
import com.SPM.Entity.Product;
import com.SPM.Mapper.ProductMapper;
import com.SPM.Service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<ProductDTO> create(@Valid @RequestBody ProductDTO dto) {
        Product p = service.create(ProductMapper.toEntity(dto));
        return ResponseEntity.ok(ProductMapper.toDTO(p));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> get(@PathVariable Long id) {
        Product p = service.get(id);
        return ResponseEntity.ok(ProductMapper.toDTO(p));
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll() {
        List<ProductDTO> list = service.getAll().stream()
            .map(ProductMapper::toDTO)
            .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @Valid @RequestBody ProductDTO dto) {
        Product p = service.update(id, ProductMapper.toEntity(dto));
        return ResponseEntity.ok(ProductMapper.toDTO(p));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/increase")
    public ResponseEntity<ProductDTO> increase(@PathVariable Long id, @RequestParam int amount) {
        Product p = service.increaseStock(id, amount);
        return ResponseEntity.ok(ProductMapper.toDTO(p));
    }
    @PostMapping("/{id}/decrease")
    public ResponseEntity<ProductDTO> decrease(@PathVariable Long id, @RequestParam int amount) {
        Product p = service.decreaseStock(id, amount);
        return ResponseEntity.ok(ProductMapper.toDTO(p));
    }
    
	

}

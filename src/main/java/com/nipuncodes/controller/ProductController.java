package com.nipuncodes.controller;

import com.nipuncodes.dto.ProductDto;
import com.nipuncodes.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{category}")
    public ResponseEntity<List<ProductDto>> getByCategory(@PathVariable("category") String category) {
        return ResponseEntity.ok(productService.getByCategory(category));
    }

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.persist(productDto));
    }
}

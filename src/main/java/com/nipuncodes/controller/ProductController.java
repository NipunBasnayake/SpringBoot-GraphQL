package com.nipuncodes.controller;

import com.nipuncodes.dto.ProductDto;
import com.nipuncodes.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getAll() {
        return productService.getAll();
    }

    @GetMapping("/category")
    public List<ProductDto>  getByCategory(String category) {
        return productService.getByCategory(category);
    }
}

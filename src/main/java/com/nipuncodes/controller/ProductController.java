package com.nipuncodes.controller;

import com.nipuncodes.dto.ProductDto;
import com.nipuncodes.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @QueryMapping
    public List<ProductDto> getAllProducts() {
        return productService.getAll();
    }

    @QueryMapping
    public List<ProductDto> getProductsByCategory(@Argument String category) {
        return productService.getByCategory(category);
    }

    @MutationMapping
    public ProductDto createProduct(@Argument("input") ProductDto productDto) {
        return productService.persist(productDto);
    }

    @MutationMapping
    public ProductDto updateProduct(@Argument Integer id, @Argument("input") ProductDto productDto) {
        return productService.update(id, productDto);
    }

    @MutationMapping
    public Boolean deleteProduct(@Argument Integer id) {
        return productService.delete(id);
    }
}

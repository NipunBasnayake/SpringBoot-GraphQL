package com.nipuncodes.service.impl;

import com.nipuncodes.dto.ProductDto;
import com.nipuncodes.entity.Product;
import com.nipuncodes.repository.ProductRepository;
import com.nipuncodes.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public List<ProductDto> getAll() {
        return productRepository.findAll().stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
    }

    @Override
    public List<ProductDto> getByCategory(String category) {
        return productRepository.findByCategory(category).stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
    }

    @Override
    public ProductDto persist(ProductDto productDto) {
        return modelMapper.map(productRepository.save(
                modelMapper.map(productDto, Product.class)
        ), ProductDto.class);
    }

    @Override
    public ProductDto update(Integer id, ProductDto productDto) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (productDto.getName() != null) existing.setName(productDto.getName());
        if (productDto.getCategory() != null) existing.setCategory(productDto.getCategory());
        if (productDto.getPrice() != null) existing.setPrice(productDto.getPrice());
        if (productDto.getStock() != null) existing.setStock(productDto.getStock());

        Product updated = productRepository.save(existing);
        return modelMapper.map(updated, ProductDto.class);
    }

    @Override
    public Boolean delete(Integer id) {
        productRepository.deleteById(id);
        return !productRepository.existsById(id);
    }
}

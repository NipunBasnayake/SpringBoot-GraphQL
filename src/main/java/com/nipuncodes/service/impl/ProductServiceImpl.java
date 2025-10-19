package com.nipuncodes.service.impl;

import com.nipuncodes.dto.ProductDto;
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
}

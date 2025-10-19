package com.nipuncodes.service;

import com.nipuncodes.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAll();

    List<ProductDto>  getByCategory(String category);
}

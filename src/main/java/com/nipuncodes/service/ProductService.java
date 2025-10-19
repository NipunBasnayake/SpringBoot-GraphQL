package com.nipuncodes.service;

import com.nipuncodes.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAll();

    List<ProductDto>  getByCategory(String category);

    ProductDto persist(ProductDto productDto);

    ProductDto update(Integer id, ProductDto productDto);

    Boolean delete(Integer id);
}

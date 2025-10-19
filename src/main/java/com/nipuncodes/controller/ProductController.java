package com.nipuncodes.controller;

import com.nipuncodes.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    final ProductService productService;
}

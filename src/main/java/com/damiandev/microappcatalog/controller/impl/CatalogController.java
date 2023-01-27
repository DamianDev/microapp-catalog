package com.damiandev.microappcatalog.controller.impl;

import com.damiandev.microappcatalog.controller.ICatalogController;
import com.damiandev.microappcatalog.model.Product;
import com.damiandev.microappcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/api/catalog")
public class CatalogController implements ICatalogController {
    private final ProductRepository productRepository;

    @Autowired
    public CatalogController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @ResponseBody
    @GetMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAll() {
        var products = productRepository.findAll().spliterator();

        return StreamSupport.stream(products, false)
                .collect(Collectors.toList());
    }
}

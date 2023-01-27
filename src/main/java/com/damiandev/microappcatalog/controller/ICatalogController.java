package com.damiandev.microappcatalog.controller;

import com.damiandev.microappcatalog.model.Product;

import java.util.List;

public interface ICatalogController {
    List<Product> getAll();
}

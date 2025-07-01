package com.vinhnd03.gio_hang.service;

import com.vinhnd03.gio_hang.entity.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Long id);
}

package com.vinhnd.quan_ly_gio_hang.service;

import com.vinhnd.quan_ly_gio_hang.entity.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Long id);
}

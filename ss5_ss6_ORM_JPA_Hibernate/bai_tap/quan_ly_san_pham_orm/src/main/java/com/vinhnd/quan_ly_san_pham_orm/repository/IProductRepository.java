package com.vinhnd.quan_ly_san_pham_orm.repository;

import com.vinhnd.quan_ly_san_pham_orm.entity.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void add(Product product);

    void update(Product product);

    void deleteById(int id);

    Product findById(int id);

    List<Product> findByName(String name);
}

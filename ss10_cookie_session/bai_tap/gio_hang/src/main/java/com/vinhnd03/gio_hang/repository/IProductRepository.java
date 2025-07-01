package com.vinhnd03.gio_hang.repository;

import com.vinhnd03.gio_hang.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {

}

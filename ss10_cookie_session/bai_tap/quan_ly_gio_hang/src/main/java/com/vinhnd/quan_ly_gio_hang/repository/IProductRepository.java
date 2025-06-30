package com.vinhnd.quan_ly_gio_hang.repository;

import com.vinhnd.quan_ly_gio_hang.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {

}

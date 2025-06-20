package com.vinhnd.quan_ly_san_pham.service;

import com.vinhnd.quan_ly_san_pham.entity.Product;
import com.vinhnd.quan_ly_san_pham.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    private final IProductRepository repository;

    public ProductService(IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(Product product) {
        repository.add(product);
    }

    @Override
    public void update(Product product) {
        repository.update(product);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public Product findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return repository.findByName(name);
    }
}

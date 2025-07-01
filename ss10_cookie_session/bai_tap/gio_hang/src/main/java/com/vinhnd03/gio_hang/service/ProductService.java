package com.vinhnd03.gio_hang.service;

import com.vinhnd03.gio_hang.entity.Product;
import com.vinhnd03.gio_hang.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService{
    private final IProductRepository repository;

    public ProductService(IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }
}

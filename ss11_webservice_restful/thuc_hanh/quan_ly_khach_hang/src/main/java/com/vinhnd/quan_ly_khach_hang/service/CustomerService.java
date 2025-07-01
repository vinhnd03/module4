package com.vinhnd.quan_ly_khach_hang.service;

import com.vinhnd.quan_ly_khach_hang.entity.Customer;
import com.vinhnd.quan_ly_khach_hang.repository.ICustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{
    private final ICustomerRepository repository;

    public CustomerService(ICustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}

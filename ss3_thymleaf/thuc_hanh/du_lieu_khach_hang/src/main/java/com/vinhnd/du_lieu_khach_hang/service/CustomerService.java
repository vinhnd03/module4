package com.vinhnd.du_lieu_khach_hang.service;

import com.vinhnd.du_lieu_khach_hang.model.Customer;
import com.vinhnd.du_lieu_khach_hang.repository.ICustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{
    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerRepository.update(id, customer);
    }

    @Override
    public void remove(int id) {
        customerRepository.remove(id);
    }
}

package com.vinhnd.du_lieu_khach_hang.service;

import com.vinhnd.du_lieu_khach_hang.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
}

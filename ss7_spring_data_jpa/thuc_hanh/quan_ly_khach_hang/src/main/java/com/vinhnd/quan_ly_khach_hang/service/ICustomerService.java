package com.vinhnd.quan_ly_khach_hang.service;

import com.vinhnd.quan_ly_khach_hang.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    Customer findById(Long id);

    void remove(Long id);
}

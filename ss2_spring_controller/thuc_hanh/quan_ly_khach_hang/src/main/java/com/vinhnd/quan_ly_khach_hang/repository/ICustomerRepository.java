package com.vinhnd.quan_ly_khach_hang.repository;

import com.vinhnd.quan_ly_khach_hang.entity.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();

    Customer findById(int id);

    void save(Customer customer);
}

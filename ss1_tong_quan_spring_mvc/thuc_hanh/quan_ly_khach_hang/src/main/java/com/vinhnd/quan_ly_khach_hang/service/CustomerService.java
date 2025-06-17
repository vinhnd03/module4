package com.vinhnd.quan_ly_khach_hang.service;

import com.vinhnd.quan_ly_khach_hang.repository.CustomerRepository;
import com.vinhnd.quan_ly_khach_hang.repository.ICustomerRepository;

public class CustomerService implements ICustomerService{
    private ICustomerRepository repository = new CustomerRepository();
}

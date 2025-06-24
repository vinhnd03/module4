package com.vinhnd.quan_ly_khach_hang.repository;

import com.vinhnd.quan_ly_khach_hang.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}

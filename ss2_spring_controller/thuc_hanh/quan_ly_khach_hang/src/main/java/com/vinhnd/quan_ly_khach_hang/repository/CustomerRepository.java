package com.vinhnd.quan_ly_khach_hang.repository;

import com.vinhnd.quan_ly_khach_hang.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository{
    private static List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer(1, "Vinh", "vinhnd@gmail.com", "Quảng Bình"));
        customers.add(new Customer(2, "Vinh2", "vinhnd@gmail.com", "Quảng Bình"));
        customers.add(new Customer(3, "Vinh3", "vinhnd@gmail.com", "Quảng Bình"));
        customers.add(new Customer(4, "Vinh4", "vinhnd@gmail.com", "Quảng Bình"));
        customers.add(new Customer(5, "Vinh5", "vinhnd@gmail.com", "Quảng Bình"));
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(int id) {
        for(Customer c : customers){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }

    @Override
    public void save(Customer customer) {
        for(int i = 0; i < customers.size(); i++){
            if(customers.get(i).getId() == customer.getId()){
                customers.set(i, customer);
                return;
            }
        }
    }
}

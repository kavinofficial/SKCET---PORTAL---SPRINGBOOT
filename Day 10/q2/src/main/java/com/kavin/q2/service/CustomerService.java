package com.kavin.q2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kavin.q2.model.Customer;
import com.kavin.q2.repository.CustomerRepo;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    public Customer post(Customer c) {
        return customerRepo.save(c);
    }

    public List<Customer> getByCity(String city) {
        return customerRepo.findByCity(city);
    }

    public List<Customer> getAll() {
        return customerRepo.findEveryone();
    }

    public Customer getById(int id) {
        return customerRepo.findById(id);
    }

    public Customer put(int id, int pincode) {
        return customerRepo.putById(id, pincode);
    }

    public boolean delById(int id) {
        return customerRepo.deleteById(id);
    }
}

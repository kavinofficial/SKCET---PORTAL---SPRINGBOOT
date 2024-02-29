package com.kavin.q2.controller;

import org.springframework.web.bind.annotation.RestController;

import com.kavin.q2.model.Customer;
import com.kavin.q2.service.CustomerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api")

public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer")
    public ResponseEntity<Customer> postMethodName(@RequestBody Customer entity) {

        Customer c = customerService.post(entity);
        if (c != null) {
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/customer/bycity/{city}")
    public ResponseEntity<List<Customer>> getCity(@PathVariable("city") String city) {
        List<Customer> list = customerService.getByCity(city);
        if (list.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getCustomer(@PathVariable("city") String city) {
        List<Customer> list = customerService.getByCity(city);
        if (list.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Customer> getId(@PathVariable("customerId") int customerId) {
        Customer p = customerService.getById(customerId);
        if (p == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PutMapping("customer/{customerId}/{pincode}")
    public ResponseEntity<Customer> putMethodName(@PathVariable("customerId") int customerId,
            @PathVariable("pincode") int pincode) {
        Customer p = customerService.put(customerId, pincode);
        if (p == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(p, HttpStatus.OK);

    }

    @DeleteMapping("/customer/{customerId}")
    public ResponseEntity<String> del(@PathVariable("customerId") int customerId) {
        if (customerService.delById(customerId)) {
            return new ResponseEntity<>("Customer deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

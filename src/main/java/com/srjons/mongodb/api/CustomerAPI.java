package com.srjons.mongodb.api;

import com.srjons.mongodb.model.Customer;
import com.srjons.mongodb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerAPI {

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping
    public void createCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
    }

    @GetMapping
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable String id) {
        return customerRepository.findById(String.valueOf(id)).orElse(null);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        customerRepository.deleteById(String.valueOf(id));
    }

    @DeleteMapping
    public void deleteAll() {
        customerRepository.deleteAll();
    }
}

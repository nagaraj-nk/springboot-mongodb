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

    @GetMapping("/info/{id}")
    public Customer findById(@PathVariable Integer id) {
        return customerRepository.findById(String.valueOf(id)).get();
    }


    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id) {
        customerRepository.deleteById(String.valueOf(id));
    }

    @DeleteMapping("/deleteAll/{passcode}")
    public ResponseEntity<String> deleteAll(@PathVariable @NonNull String passcode) {
        if (passcode.equals("mongo_passcode")) {
            customerRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}

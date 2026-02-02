package com.example.Bank.controller;

import com.example.Bank.model.Customer;
import com.example.Bank.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private static final Logger logger =
            LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    // Add customer
    @PostMapping("/customers")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {

        Customer savedCustomer = customerService.addCustomer(customer);
        logger.info("Customer added successfully with id {}", savedCustomer.getCustomerId());

        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    // Get customer by ID
    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable long id) {

        Optional<Customer> customer = customerService.findCustomerById(id);

        if (!customer.isPresent()) {
            logger.error("Customer not found with id {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        logger.info("Customer found with id {}", id);
        return new ResponseEntity<>(customer.get(), HttpStatus.OK);
    }

    // Get all customers
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {

        List<Customer> customers = customerService.findAllCustomers();
        logger.info("Fetched all customers. Count: {}", customers.size());

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    // Delete customer
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable long id) {

        boolean deleted = customerService.deleteCustomer(id);

        if (!deleted) {
            logger.error("Delete failed. Customer not found with id {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        logger.info("Customer deleted successfully with id {}", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

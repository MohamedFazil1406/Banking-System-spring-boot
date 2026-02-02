package com.example.Bank.service;

import com.example.Bank.model.Customer;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomerService {

    private List<Customer> customers=new ArrayList<>();

    public Customer addCustomer(Customer customer){
        customers.add(customer);
        return customer;

    }

    public Optional<Customer> findCustomerById(long customerId){
        for(Customer customer:customers){
            if(customer.getCustomerId()==customerId){
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }

    public List<Customer> findAllCustomers(){
      return customers;
    }

    public boolean deleteCustomer(long customerId){
       return customers.removeIf(customer -> customer.getCustomerId() == customerId);
    }


}

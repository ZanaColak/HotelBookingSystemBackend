package com.example.hotelbookingsystembackend.service;

import com.example.hotelbookingsystembackend.model.Customer;
import com.example.hotelbookingsystembackend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(int id, Customer updatedCustomer) {
        if (customerRepository.existsById(id)) {
            updatedCustomer.setCustomerId(id);
            return customerRepository.save(updatedCustomer);
        } else {
            return null;
        }
    }

    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }
}

package com.example.hotelbookingsystembackend.repository;

import com.example.hotelbookingsystembackend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Find customers by email domain (e.g., "@gmail.com")
    List<Customer> findByEmailEndingWith(String domain);

    // Find customers whose phone number starts with a given prefix
    List<Customer> findByPhoneNumberStartingWith(String prefix);
}

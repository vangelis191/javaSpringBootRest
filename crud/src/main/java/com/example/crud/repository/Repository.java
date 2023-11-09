package com.example.crud.repository;

import com.example.crud.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Repository extends JpaRepository<Customer, Integer> {
    // Additional custom queries can be added here if needed
}

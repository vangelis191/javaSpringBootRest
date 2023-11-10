package com.example.crud.services;

import com.example.crud.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.crud.repository.Repository;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private  Repository repository;


    public List<Customer> getCustomer() {
        return repository.findAll();
    }

    public Customer saveCustomer(Customer example) {
        return repository.save(example);
    }
}

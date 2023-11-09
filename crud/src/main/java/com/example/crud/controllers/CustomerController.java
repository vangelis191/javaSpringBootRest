package com.example.crud.controllers;

import com.example.crud.models.Customer;
import com.example.crud.services.CusotmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    public static int  number = 0;

    @Autowired
    private CusotmerService service;

    @GetMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(){
        number++;
        Customer res = this.service.saveCustomer(new Customer("TestCustomer"+number,"testSurname"+number, "test@test"+number+".com", "999999"+number));
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping("/cusotmer")
    public List<Customer> getCustomer(){
        return this.service.getCustomer();
    }

}

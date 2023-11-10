package com.example.crud.controller;

import com.example.crud.controllers.CustomerController;
import com.example.crud.models.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;


import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Fail.fail;
import static org.mockito.Mockito.when;

import com.example.crud.services.CustomerService;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.hamcrest.Matchers.*;
@WebMvcTest(value= CustomerController.class)
public class CustomerControllerTest {


    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private CustomerService service;
    @Test
    public void testGetCustomer() throws Exception {
        List<Customer> expectedCustomers = Arrays.asList(
                new Customer(1, "TestCustomer1", "testSurname1", "test@test1.com", "9999991"),
                new Customer(2, "TestCustomer2", "testSurname2", "test@test2.com", "9999992")
        );

        // Mock the service method to return the sample customers
        when(service.getCustomer()).thenReturn(expectedCustomers);

        RequestBuilder request  = MockMvcRequestBuilders.get("http://localhost:8080/cusotmer")
                .accept(MediaType.APPLICATION_JSON);
        ResultActions resultActions = mockMvc.perform(request);

        MvcResult mvcResult = resultActions
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // You can access various details from the MvcResult
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
        System.out.println(status);

    }

}
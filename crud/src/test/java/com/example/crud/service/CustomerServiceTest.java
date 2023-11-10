package com.example.crud.service;

import com.example.crud.models.Customer;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import com.example.crud.services.CustomerService;
import com.example.crud.repository.Repository;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {

    @InjectMocks
    private CustomerService service;

    @Mock
    private Repository repository;

    @Test
    public void testGetCustomer() {
        // Initialize mocks
        MockitoAnnotations.initMocks(this);

        // Define sample data
        List<Customer> expectedCustomers = Arrays.asList(
                new Customer(1, "TestCustomer1", "testSurname1", "test@test1.com", "9999991"),
                new Customer(2, "TestCustomer2", "testSurname2", "test@test2.com", "9999992")
        );

        // Mock the repository behavior
        when(repository.findAll()).thenReturn(expectedCustomers);

        // Call the service method
        List<Customer> actualCustomers = service.getCustomer();

        // Verify the result is not null
        assertNotNull(actualCustomers);

        System.out.println(actualCustomers);
        System.out.println(expectedCustomers);
        // Verify the result matches the expected data
        assertEquals(expectedCustomers, actualCustomers);
    }
}

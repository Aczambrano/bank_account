package com.neoris.bankclient.application.command.handler;

import com.neoris.bankclient.application.command.CreateCustomerCommand;
import com.neoris.bankclient.application.command.UpdateCustomerCommand;
import com.neoris.bankclient.application.exception.EntityNotFoundException;
import com.neoris.bankclient.application.mapper.CustomerCommandMapper;
import com.neoris.bankclient.application.port.output.ICustomerRepository;
import com.neoris.bankclient.application.port.output.IPasswordEncoder;
import com.neoris.bankclient.domain.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UpdateCustomerHandlerTest {

    @Mock
    private ICustomerRepository customerRepository;

    @Mock
    private IPasswordEncoder passwordEncoder;

    @Mock
    private CustomerCommandMapper mapper;

    private UpdateCustomerHandler updateHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        updateHandler = new UpdateCustomerHandler(customerRepository, passwordEncoder, mapper);
    }

    @Test
    void testHandleSuccessfully() {
        UpdateCustomerCommand command = new UpdateCustomerCommand(
                1, "John Doe", "Male", 30, "123456789",
                "123 Main St", "555-1234", "password123", true
        );

        Customer mappedCustomer = new Customer(
                1, "password123", true
        );
        mappedCustomer.setName("John Doe");
        mappedCustomer.setGender("Male");
        mappedCustomer.setAge(30);
        mappedCustomer.setIdentification("123456789");
        mappedCustomer.setAddress("123 Main St");
        mappedCustomer.setPhone("555-1234");

        when(customerRepository.findById(command.customerId())).thenReturn(Optional.of(mappedCustomer));
        when(mapper.toCustomer(command)).thenReturn(mappedCustomer);
        when(passwordEncoder.encode(command.password())).thenReturn("encodedPassword");
        when(customerRepository.save(mappedCustomer)).thenReturn(mappedCustomer);

        Customer result = updateHandler.handle(command);

        assertNotNull(result);
        assertEquals("encodedPassword", result.getPassword());
        verify(customerRepository).findById(command.customerId());
        verify(mapper).toCustomer(command);
        verify(passwordEncoder).encode(command.password());
        verify(customerRepository).save(mappedCustomer);
    }

    @Test
    void testHandleWithCustomerNotFound() {
        UpdateCustomerCommand command = new UpdateCustomerCommand(
                1, "John Doe", "Male", 30, "123456789",
                "123 Main St", "555-1234", "password123", true
        );

        when(customerRepository.findById(command.customerId())).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class,
                () -> updateHandler.handle(command));

        assertEquals("Customer not found", exception.getMessage());
        verify(customerRepository).findById(command.customerId());
        verify(mapper, never()).toCustomer((CreateCustomerCommand) any());
        verify(passwordEncoder, never()).encode(any());
        verify(customerRepository, never()).save(any());
    }
}

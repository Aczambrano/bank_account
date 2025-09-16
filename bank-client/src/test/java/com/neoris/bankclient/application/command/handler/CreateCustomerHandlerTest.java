package com.neoris.bankclient.application.command.handler;

import com.neoris.bankclient.application.command.CreateCustomerCommand;
import com.neoris.bankclient.application.exception.ConflictException;
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

public class CreateCustomerHandlerTest {

    @Mock
    private ICustomerRepository customerRepository;

    @Mock
    private IPasswordEncoder passwordEncoder;

    @Mock
    private CustomerCommandMapper mapper;

    private CreateCustomerHandler createHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        createHandler = new CreateCustomerHandler(customerRepository, passwordEncoder, mapper);
    }

    @Test
    void testHandleSuccessfully() {
        CreateCustomerCommand command = new CreateCustomerCommand(
                "John Doe", "Male", 30, "123456789", "123 Main St", "555-1234", "password123", true
        );

        Customer mappedCustomer = new Customer(
                "John Doe", "Male", 30, "123456789",
                "123 Main St", "555-1234", null, "password123", true
        );

        when(customerRepository.findByIdentification(command.identification())).thenReturn(Optional.empty());
        when(mapper.toCustomer(command)).thenReturn(mappedCustomer);
        when(passwordEncoder.encode(command.password())).thenReturn("encodedPassword");
        when(customerRepository.save(mappedCustomer)).thenReturn(mappedCustomer);

        Customer result = createHandler.handle(command);

        assertNotNull(result);
        assertEquals("encodedPassword", result.getPassword());
        verify(customerRepository).findByIdentification(command.identification());
        verify(mapper).toCustomer(command);
        verify(passwordEncoder).encode(command.password());
        verify(customerRepository).save(mappedCustomer);
    }

    @Test
    void testHandleWithConflict() {
        CreateCustomerCommand command = new CreateCustomerCommand(
                "John Doe", "Male", 30, "123456789", "123 Main St", "555-1234", "password123", true
        );

        Customer existingCustomer = new Customer(
                "Existing", "Male", 25, "123456789",
                "Address", "555-0000", 1, "password", true
        );

        when(customerRepository.findByIdentification(command.identification()))
                .thenReturn(Optional.of(existingCustomer));

        ConflictException exception = assertThrows(ConflictException.class,
                () -> createHandler.handle(command));

        assertEquals("The customer with that identification is already registered.", exception.getMessage());

        verify(customerRepository).findByIdentification(command.identification());
        verify(mapper, never()).toCustomer((CreateCustomerCommand) any());
        verify(passwordEncoder, never()).encode(any());
        verify(customerRepository, never()).save(any());
    }
}

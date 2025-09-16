package com.neoris.bankclient.application.command.handler;

import com.neoris.bankclient.application.command.DeleteCustomerCommand;
import com.neoris.bankclient.application.exception.EntityNotFoundException;
import com.neoris.bankclient.application.port.output.ICustomerRepository;
import com.neoris.bankclient.domain.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DeleteCustomerHandlerTest {

    @Mock
    private ICustomerRepository customerRepository;

    private DeleteCustomerHandler deleteHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        deleteHandler = new DeleteCustomerHandler(customerRepository);
    }

    @Test
    void testHandleSuccessfully() {
        Integer customerId = 1;
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setStatus(true);

        DeleteCustomerCommand command = new DeleteCustomerCommand(customerId);

        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));
        when(customerRepository.update(customer)).thenReturn(customer);

        deleteHandler.handle(command);

        assertFalse(customer.getStatus());
        verify(customerRepository).findById(customerId);
        verify(customerRepository).update(customer);
    }

    @Test
    void testHandleWithCustomerNotFound() {
        Integer customerId = 1;
        DeleteCustomerCommand command = new DeleteCustomerCommand(customerId);

        when(customerRepository.findById(customerId)).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class,
                () -> deleteHandler.handle(command));

        assertEquals("Customer not found", exception.getMessage());
        verify(customerRepository).findById(customerId);
        verify(customerRepository, never()).update(any());
    }
}

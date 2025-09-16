package com.neoris.bankclient.application.command.handler;

import com.neoris.bankclient.application.command.DeleteCustomerCommand;
import com.neoris.bankclient.application.exception.EntityNotFoundException;
import com.neoris.bankclient.application.port.output.ICustomerRepository;
import com.neoris.bankclient.domain.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCustomerHandler {

    private final ICustomerRepository customerRepository;

    public void handle(DeleteCustomerCommand command) {
        Customer customer = customerRepository.findById(command.customerId())
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

        customer.setStatus(false);
        customerRepository.update(customer);
    }
}

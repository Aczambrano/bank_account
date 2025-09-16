package com.neoris.bankclient.application.command.handler;

import com.neoris.bankclient.application.command.UpdateCustomerCommand;
import com.neoris.bankclient.application.exception.EntityNotFoundException;
import com.neoris.bankclient.application.mapper.CustomerCommandMapper;
import com.neoris.bankclient.application.port.output.ICustomerRepository;
import com.neoris.bankclient.application.port.output.IPasswordEncoder;
import com.neoris.bankclient.domain.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateCustomerHandler {

    private final ICustomerRepository customerRepository;
    private final IPasswordEncoder passwordEncoder;
    private final CustomerCommandMapper mapper;

    public Customer handle(UpdateCustomerCommand command) {
        customerRepository.findById(command.customerId())
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

        Customer customer = mapper.toCustomer(command);
        customer.setPassword(passwordEncoder.encode(command.password()));
        return customerRepository.save(customer);
    }
}

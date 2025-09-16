package com.neoris.bankclient.application.command.handler;

import com.neoris.bankclient.application.command.CreateCustomerCommand;
import com.neoris.bankclient.application.exception.ConflictException;
import com.neoris.bankclient.application.mapper.CustomerCommandMapper;
import com.neoris.bankclient.application.port.output.ICustomerRepository;
import com.neoris.bankclient.application.port.output.IPasswordEncoder;
import com.neoris.bankclient.domain.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCustomerHandler {

    private final ICustomerRepository customerRepository;
    private final IPasswordEncoder passwordEncoder;
    private final CustomerCommandMapper mapper;

    public Customer handle(CreateCustomerCommand command) {
        customerRepository.findByIdentification(command.identification())
                .ifPresent(c -> {
                    throw new ConflictException("The customer with that identification is already registered.");
                });

        Customer customer = mapper.toCustomer(command);
        customer.setPassword(passwordEncoder.encode(command.password()));

        return customerRepository.save(customer);
    }
}

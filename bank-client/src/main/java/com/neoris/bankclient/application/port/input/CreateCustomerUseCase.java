package com.neoris.bankclient.application.port.input;

import com.neoris.bankclient.application.exception.ConflictException;
import com.neoris.bankclient.application.port.output.ICustomerRepository;
import com.neoris.bankclient.application.port.output.IPasswordEncoder;
import com.neoris.bankclient.domain.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateCustomerUseCase {

    private final ICustomerRepository customerRepository;
    private final IPasswordEncoder passwordEncoder;

    public Customer execute(Customer customer) {
        customerRepository.findByIdentification(customer.getIdentification())
                .ifPresent( customer1 -> {
                    throw new ConflictException("The customer with that identification is already registered.");
                });

        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerRepository.save(customer);
    }

}


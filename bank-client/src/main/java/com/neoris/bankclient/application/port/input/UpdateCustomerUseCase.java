package com.neoris.bankclient.application.port.input;

import com.neoris.bankclient.application.exception.EntityNotFoundException;
import com.neoris.bankclient.application.port.output.ICustomerRepository;
import com.neoris.bankclient.application.port.output.IPasswordEncoder;
import com.neoris.bankclient.domain.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateCustomerUseCase {

    private final ICustomerRepository customerRepository;
    private final IPasswordEncoder passwordEncoder;

    public Customer execute(Customer customer){

        customerRepository.findById(customer.getCustomerId())
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerRepository.update(customer);
    }
}


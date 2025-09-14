package com.neoris.bankclient.application.port.input;

import com.neoris.bankclient.application.exception.EntityNotFoundException;
import com.neoris.bankclient.application.port.output.ICustomerRepository;
import com.neoris.bankclient.domain.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteCustomerUseCase {

    private final ICustomerRepository customerRepository;

    public void execute(Integer identification) {

        Customer customer = customerRepository.findById(identification)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

        customer.setStatus(false);
        customerRepository.update(customer);
    }

}


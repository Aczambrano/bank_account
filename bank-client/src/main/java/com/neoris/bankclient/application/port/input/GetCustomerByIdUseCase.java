package com.neoris.bankclient.application.port.input;

import com.neoris.bankclient.application.port.output.ICustomerRepository;
import com.neoris.bankclient.domain.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetCustomerByIdUseCase {

    private final ICustomerRepository customerRepository;

    public Optional<Customer> execute(Integer id) {
        return customerRepository.findById(id);
    }
}

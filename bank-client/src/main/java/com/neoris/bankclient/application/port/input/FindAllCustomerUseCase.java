package com.neoris.bankclient.application.port.input;

import com.neoris.bankclient.application.port.output.ICustomerRepository;
import com.neoris.bankclient.domain.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FindAllCustomerUseCase {

    private final ICustomerRepository customerRepository;

    public List<Customer> execute() {
        return customerRepository.findAll();
    }
}

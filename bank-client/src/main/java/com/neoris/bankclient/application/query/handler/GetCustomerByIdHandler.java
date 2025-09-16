package com.neoris.bankclient.application.query.handler;

import com.neoris.bankclient.application.port.output.ICustomerRepository;
import com.neoris.bankclient.application.query.GetCustomerByIdQuery;
import com.neoris.bankclient.domain.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetCustomerByIdHandler {

    private final ICustomerRepository customerRepository;

    public Optional<Customer> handle(GetCustomerByIdQuery query) {
        return customerRepository.findById(query.id());
    }
}

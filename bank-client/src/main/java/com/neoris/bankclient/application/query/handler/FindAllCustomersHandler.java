package com.neoris.bankclient.application.query.handler;

import com.neoris.bankclient.application.port.output.ICustomerRepository;
import com.neoris.bankclient.application.query.FindAllCustomersQuery;
import com.neoris.bankclient.domain.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllCustomersHandler {

    private final ICustomerRepository customerRepository;

    public List<Customer> handle(FindAllCustomersQuery query) {
        return customerRepository.findAll();
    }
}

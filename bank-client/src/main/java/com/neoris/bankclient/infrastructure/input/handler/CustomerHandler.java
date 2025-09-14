package com.neoris.bankclient.infrastructure.input.handler;

import com.neoris.bankclient.application.port.input.CreateCustomerUseCase;
import com.neoris.bankclient.application.port.input.DeleteCustomerUseCase;
import com.neoris.bankclient.application.port.input.FindAllCustomerUseCase;
import com.neoris.bankclient.application.port.input.UpdateCustomerUseCase;
import com.neoris.bankclient.domain.model.Customer;
import com.neoris.bankclient.infrastructure.input.dto.CustomerRequest;
import com.neoris.bankclient.infrastructure.input.dto.CustomerResponse;
import com.neoris.bankclient.infrastructure.input.mapper.CustomerMapper;
import com.neoris.bankclient.infrastructure.output.mapper.CustomerEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CustomerHandler {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final DeleteCustomerUseCase deleteCustomerUseCase;
    private final FindAllCustomerUseCase findAllCustomerUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;
    private final CustomerMapper customerMapper;

    public List<CustomerResponse> getCustomers() {
        return findAllCustomerUseCase.execute().stream()
                .map(customerMapper::toResponse)
                .collect(Collectors.toUnmodifiableList());
    }

    public CustomerResponse createCustomer(CustomerRequest customerRequest) {
        Customer customer = customerMapper.toEntity(customerRequest);
        return customerMapper.toResponse(createCustomerUseCase.execute(customer));
    }

    public CustomerResponse updateCustomer(CustomerRequest customerRequest) {
        Customer customer = customerMapper.toEntity(customerRequest);
        return customerMapper.toResponse(updateCustomerUseCase.execute(customer));
    }

    public void deleteCustomer(Integer customerId) {
        deleteCustomerUseCase.execute(customerId);
    }
}
